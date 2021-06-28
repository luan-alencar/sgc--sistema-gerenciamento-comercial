package david.augusto.luan.sgc.service.impl;

import david.augusto.luan.sgc.dominio.Usuario;
import david.augusto.luan.sgc.repository.UsuarioRepository;
import david.augusto.luan.sgc.service.PessoaFisicaService;
import david.augusto.luan.sgc.service.ServiceGenericEntity;
import david.augusto.luan.sgc.service.dto.UsuarioDTO;
import david.augusto.luan.sgc.service.exceptions.RegraNegocioException;
import david.augusto.luan.sgc.service.impl.utils.ConstantsUtil;
import david.augusto.luan.sgc.service.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

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
//        validarCpfEMail(usuarioDTO);
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        return usuarioMapper.toDTO(usuarioRepository.save(usuario));
    }

    private UsuarioDTO obterPorCPF(String cpf) {
        Usuario usuario = usuarioRepository.findByCpf(cpf);
        if (Objects.isNull(usuario)) {
            usuario = new Usuario();
            usuario.setCpf(cpf);
        }
        return usuarioMapper.toDTO(usuario);

    }

    private String mascararCpf(String cpfSemFormatacao) {
        return new StringBuilder().append(cpfSemFormatacao.substring(0, 3)).append(ConstantsUtil.PONTO)
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
