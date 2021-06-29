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

import static david.augusto.luan.sgc.service.impl.utils.ConstantsUtil.*;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UsuarioServiceImpl implements ServiceGenericEntity<UsuarioDTO> {

    private final UsuarioMapper mapper;
    private final UsuarioRepository repository;

    private static final Boolean NOT_ADMIN = false;
    private static final LocalDate DATA_ATUAL = LocalDate.now();

    @Override
    public List<UsuarioDTO> buscarTodos() {
        return mapper.toListDTO(repository.findAll());
    }

    @Override
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        usuarioDTO.setIsAdmin(NOT_ADMIN);
        obterPorCpf(usuarioDTO.getCpf());
        validarCpfEMail(usuarioDTO);
        verificarDataNascimentoUsuario(usuarioDTO);
        gerarChaveUnicaDeAcesso(usuarioDTO);
        Usuario usuario = mapper.toEntity(usuarioDTO);
        return mapper.toDTO(repository.save(usuario));
    }


    public List<DominioFixoDTO> obterPorCpf(String cpf) {
        String cpfSemFormatacao = cpf.replaceAll(REGEX_PONTO_HIFEN, StringUtils.EMPTY);
        List<DominioFixoDTO> usuarios = repository.obterPorCpf(cpfSemFormatacao);
        usuarios.forEach(usuario -> {

            String cpfFormatado = mascararCpf(usuario.getLabel());
            usuario.setLabel(cpfFormatado);
        });

        return usuarios;
    }

    private String mascararCpf(String cpfSemFormatacao) {
        return new StringBuilder().append(cpfSemFormatacao.substring(POSICAO_ZERO, POSICAO_TRES)).append(PONTO)
                .append(cpfSemFormatacao.substring(POSICAO_TRES, POSICAO_SEIS)).append(PONTO)
                .append(cpfSemFormatacao.substring(POSICAO_SEIS, POSICAO_NOVE)).append(HIFEN)
                .append(cpfSemFormatacao.substring(POSICAO_NOVE, POSICAO_ONZE)).toString();
    }

    private Boolean validarCpfEMail(UsuarioDTO usuarioDto) {
        return repository.findIdsByCpfOrEmail(usuarioDto)
                .orElseThrow(() -> new RegraNegocioException(USUARIO_NAO_CADASTRADO, USUARIO_CPF_EMAIL_DUPLICADO));
    }

    private void verificarDataNascimentoUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getDataNascimento().isAfter(DATA_ATUAL)) {
            throw new RegraNegocioException(USUARIO_NAO_CADASTRADO, "Data de nascimento invalida");
        }
    }

    private UsuarioDTO gerarChaveUnicaDeAcesso(UsuarioDTO usuarioDTO) {
        Usuario usuario = mapper.toEntity(usuarioDTO);
        usuario.setChaveUnica(UUID.randomUUID().toString());
        return mapper.toDTO(usuario);
    }

    @Override
    public void delete(UsuarioDTO entity) {

    }

    @Override
    public UsuarioDTO buscarPorId(Integer id) {
        return mapper.toDTO(repository.findById(id)
                .orElseThrow(() -> new RegraNegocioException(USUARIO_NAO_CADASTRADO, ERROR_TITLE)));
    }
}
