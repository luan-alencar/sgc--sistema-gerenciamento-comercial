package david.augusto.luan.sgc.service.impl;

import david.augusto.luan.sgc.dominio.Usuario;
import david.augusto.luan.sgc.repository.UsuarioRepository;
import david.augusto.luan.sgc.service.UsuarioService;
import david.augusto.luan.sgc.service.dto.DominioFixoDTO;
import david.augusto.luan.sgc.service.dto.UsuarioDTO;
import david.augusto.luan.sgc.service.exceptions.RegraNegocioException;
import david.augusto.luan.sgc.service.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static david.augusto.luan.sgc.service.impl.utils.ConstantsUtil.*;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

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
        validacoesNecessarias(usuarioDTO);
        return mapper.toDTO(repository.save(mapper.toEntity(usuarioDTO)));
    }

    public UsuarioDTO validacoesNecessarias(UsuarioDTO usuario) {
        obterPorCpf(usuario.getCpf());
        validarCpfEMail(usuario);
        verificarDataNascimentoUsuario(usuario);
        gerarChaveUnicaDeAcesso(usuario);
        return usuario;
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

    private UsuarioDTO verificarDataNascimentoUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getDataNascimento().isAfter(DATA_ATUAL)) {
            throw new RegraNegocioException(USUARIO_NAO_CADASTRADO, "Data de nascimento invalida");
        }
        return usuarioDTO;
    }

    private Usuario gerarChaveUnicaDeAcesso(UsuarioDTO usuario) {
        Usuario salvarChaveDeAcesso = mapper.toEntity(usuario);
        salvarChaveDeAcesso.setChaveUnica(UUID.randomUUID().toString());
        return salvarChaveDeAcesso;
    }

    @Override
    public void delete(UsuarioDTO entity) {

    }

    @Override
    public UsuarioDTO buscarPorId(Integer id) {
        return mapper.toDTO(repository.findById(id)
                .orElseThrow(() -> new RegraNegocioException(USUARIO_NAO_CADASTRADO, ERROR_TITLE)));
    }

    @Override
    public UsuarioDTO atualizar(UsuarioDTO usuarioDTO) throws RegraNegocioException {
        Usuario usuario = mapper.toEntity(usuarioDTO);
        return this.salvar(mapper.toDTO(usuario));
    }
}
