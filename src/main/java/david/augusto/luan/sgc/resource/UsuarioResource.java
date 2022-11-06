package david.augusto.luan.sgc.resource;

import david.augusto.luan.sgc.domain.Usuario;
import david.augusto.luan.sgc.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/usuarios")
public class UsuarioResource {

    private final UsuarioService usuarioServico;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return new ResponseEntity<>(usuarioServico.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioServico.obterPorID(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioServico.salvar(usuario));

    }


}
