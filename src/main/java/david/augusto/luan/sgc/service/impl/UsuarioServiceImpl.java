package david.augusto.luan.sgc.service.impl;

import david.augusto.luan.sgc.dominio.Usuario;
import david.augusto.luan.sgc.repository.UsuarioRepository;
import david.augusto.luan.sgc.service.ServiceGenericEntity;
import david.augusto.luan.sgc.service.dto.UsuarioDTO;
import david.augusto.luan.sgc.service.exceptions.RegraNegocioException;
import david.augusto.luan.sgc.service.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioServiceImpl implements ServiceGenericEntity<UsuarioDTO, Usuario> {

    private static final LocalDate DATA_ATUAL = LocalDate.now();
    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> findAll() {
        return usuarioMapper.toListDTO(usuarioRepository.findAll());
    }

    @Override
    public UsuarioDTO save(Usuario usuario) {
        usuario.setIsAdmin(false);
        UsuarioDTO usuarioDTO = usuarioMapper.toDTO(usuario);
        this.verificacoesDeUsuario(usuarioDTO);
        return usuarioDTO;
    }

    @Override
    public void delete(UsuarioDTO entity) {

    }

    @Override
    public void deleteById(Long id) {

    }

    private UsuarioDTO verificacoesDeUsuario(UsuarioDTO usuarioDTO) throws RegraNegocioException {

        verificarUsuarioPorEmail(usuarioRepository.obterPorEmail(usuarioDTO.getEmail()));
        verificarUsuarioPorCpf(usuarioRepository.obterPorCPF(usuarioDTO.getCpf()));
        verificarDataNascimentoUsuario(usuarioDTO);

        return gerarChaveUnicaDeAcesso(usuarioDTO);
    }

    private void verificarUsuarioPorEmail(Usuario emailUsuario) {
        usuarioRepository.obterPorCPF(emailUsuario.getCpf());
    }

    private void verificarUsuarioPorCpf(Usuario cpfUsuario) {
        usuarioRepository.obterPorCPF(cpfUsuario.getCpf());
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

}
