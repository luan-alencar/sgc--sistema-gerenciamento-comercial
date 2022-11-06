package david.augusto.luan.sgc.service;

import david.augusto.luan.sgc.UsuarioRepository;
import david.augusto.luan.sgc.domain.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public List<Usuario> listar() {
        return repository.findAll();
    }


    public Usuario salvar(Usuario usuario) {
        Usuario u = repository.save(usuario);
        return repository.save(u);
    }

    public Usuario obterPorID(Long id) throws RuntimeException {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Usuario nao encontrado!"));
    }

}
