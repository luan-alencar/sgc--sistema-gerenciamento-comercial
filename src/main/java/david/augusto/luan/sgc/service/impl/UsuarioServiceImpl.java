package david.augusto.luan.sgc.service.impl;

import david.augusto.luan.sgc.dominio.Usuario;
import david.augusto.luan.sgc.repository.UsuarioRepository;
import david.augusto.luan.sgc.service.ServiceGenericEntity;
import david.augusto.luan.sgc.service.dto.DominioFixoDTO;
import david.augusto.luan.sgc.service.dto.UsuarioDTO;
import david.augusto.luan.sgc.service.exceptions.RegraNegocioException;
import david.augusto.luan.sgc.service.impl.utils.ConstantsUtil;
import david.augusto.luan.sgc.service.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static david.augusto.luan.sgc.service.impl.utils.ConstantsUtil.POSICAO_TRES;
import static david.augusto.luan.sgc.service.impl.utils.ConstantsUtil.POSICAO_ZERO;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UsuarioServiceImpl implements ServiceGenericEntity<UsuarioDTO> {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;

    private static final Boolean NOT_ADMIN = false;
    private static final LocalDate DATA_ATUAL = LocalDate.now();

    @Override
    public List<UsuarioDTO> findAll() {
        return usuarioMapper.toListDTO(usuarioRepository.findAll());
    }

    @Override
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        usuarioDTO.setIsAdmin(NOT_ADMIN);
        obterPorCpf(usuarioDTO.getCpf());
        validarCpfEMail(usuarioDTO);
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        return usuarioMapper.toDTO(usuarioRepository.save(usuario));
    }



    private List<DominioFixoDTO> obterPorCpf(String cpf) {
        String cpfSemFormatacao = cpf.replaceAll(ConstantsUtil.REGEX_PONTO_HIFEN, StringUtils.EMPTY);
        List<DominioFixoDTO> usuarios = usuarioRepository.obterPorCpf(cpfSemFormatacao);
        usuarios.forEach(usuario -> {

            String cpfFormatado = mascararCpf(usuario.getLabel());
            usuario.setLabel(cpfFormatado);
        });

        return usuarios;

    }

    private String mascararCpf(String cpfSemFormatacao) {
        return new StringBuilder().append(cpfSemFormatacao.substring(POSICAO_ZERO, POSICAO_TRES)).append(ConstantsUtil.PONTO)
                .append(cpfSemFormatacao.substring(3, 6)).append(ConstantsUtil.PONTO)
                .append(cpfSemFormatacao.substring(6, 9)).append(ConstantsUtil.HIFEN)
                .append(cpfSemFormatacao.substring(9, 11)).toString();
    }

    private Boolean validarCpfEMail(UsuarioDTO usuarioDto) {
        return usuarioRepository.findIdsByCpfOrEmail(usuarioDto)
                .orElseThrow(() -> new RegraNegocioException(ConstantsUtil.USUARIO_CPF_EMAIL_DUPLICADO));
    }

    private void verificarDataNascimentoUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getDataNascimento().isAfter(DATA_ATUAL)) {
            throw new RegraNegocioException("Data de nascimento invalida");
        }
    }

    private UsuarioDTO gerarChaveUnicaDeAcesso(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setChaveUnica(UUID.randomUUID().toString());
        return usuarioMapper.toDTO(usuario);
    }

    @Override
    public void delete(UsuarioDTO entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
