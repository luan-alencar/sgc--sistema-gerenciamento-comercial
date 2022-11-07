package david.augusto.luan.sgc;

import david.augusto.luan.sgc.domain.Usuario;
import david.augusto.luan.sgc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;

@Component
public class UsuarioBuilder extends ConstrutorDeEntidade<Usuario> {

    @Autowired
    private UsuarioService usuarioServico;


    @Override
    public Usuario construirEntidade() throws ParseException {
        Usuario usuario = new Usuario();
        usuario.setId(8L);
        usuario.setNome("luan alencar");

        return usuario;
    }

    @Override
    protected Usuario persistir(Usuario entidade) {
        Usuario usuario = usuarioServico.salvar(entidade);
        return usuario;
    }

    @Override
    protected Collection<Usuario> obterTodos() {
        return usuarioServico.listar();
    }


    @Override
    protected Usuario obterPorId(Long id) {
        return usuarioServico.obterPorID(id);
    }
}