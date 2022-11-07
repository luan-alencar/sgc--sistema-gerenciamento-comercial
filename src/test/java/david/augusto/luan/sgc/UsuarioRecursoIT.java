package david.augusto.luan.sgc;

import david.augusto.luan.sgc.domain.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@Transactional
public class UsuarioRecursoIT extends IntegracaoTest {

    @Autowired
    private UsuarioBuilder usuarioBuilder;


    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @BeforeEach
    void incializar() {
        usuarioRepositorio.deleteAll();
    }

    @Test
    void listarTest() throws Exception {
        usuarioBuilder.construir();
        getMockMvc().perform(get("/api/usuarios"))
                .andExpect(status().isOk());

    }

    @Test
    void obterPorIdTest() throws Exception {
        Usuario usuario = usuarioBuilder.construir();
        getMockMvc().perform(get("/api/usuarios/" + usuario.getId()))
                .andExpect(status().isOk());

    }

    @Test
    void salvarTest() throws Exception {
        Usuario usuario = usuarioBuilder.construirEntidade();
        usuario.setNome("teste");

        getMockMvc().perform(post("/api/usuarios")
                        .contentType(TestUtil.APPLICATION_JSON_UTF8)
                        .content(TestUtil.convertObjectToJsonBytes(usuario)))
                .andExpect(status().isCreated());
    }
}