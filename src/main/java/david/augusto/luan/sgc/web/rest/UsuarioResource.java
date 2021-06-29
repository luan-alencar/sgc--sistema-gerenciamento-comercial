package david.augusto.luan.sgc.web.rest;

import david.augusto.luan.sgc.dominio.Usuario;
import david.augusto.luan.sgc.service.UsuarioService;
import david.augusto.luan.sgc.service.dto.DominioFixoDTO;
import david.augusto.luan.sgc.service.dto.UsuarioDTO;
import david.augusto.luan.sgc.service.impl.UsuarioServiceImpl;
import david.augusto.luan.sgc.service.mapper.UsuarioMapper;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/usuarios")
public class UsuarioResource {

    private final UsuarioService service;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> buscarTodosUsuarios() {
        log.debug("REST request para buscar todos Usuarios cadastrados");
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("listar/cpf/{cpf}")
    @Timed
    public ResponseEntity<List<DominioFixoDTO>> buscarPorCpf(@PathVariable String cpf) {
        log.debug("REST request para buscar Usuario por CPF");
        return ResponseEntity.ok(service.obterPorCpf(cpf));
    }

    @PostMapping("/salvar")
    @Timed
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody Usuario usuario) {
        log.debug("REST request para cadastrar um Usuario");
        return ResponseEntity.ok(service.salvar(usuario));
    }
}

