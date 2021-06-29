package david.augusto.luan.sgc.web.rest;

import david.augusto.luan.sgc.service.dto.DominioFixoDTO;
import david.augusto.luan.sgc.service.dto.UsuarioDTO;
import david.augusto.luan.sgc.service.impl.UsuarioServiceImpl;
import david.augusto.luan.sgc.service.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/usuarios")
public class UsuarioResource {

    private final UsuarioServiceImpl service;
    private final UsuarioMapper mapper;

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> buscarTodosUsuarios() {
        log.debug("REST request para buscar todos Usuarios cadastrados");
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("listar/cpf/{cpf}")
    @Timed
    public ResponseEntity<List<DominioFixoDTO>> buscarPorCpf(@PathVariable String cpf) {
        log.debug("REST request para buscar Usuario por CPF");
        return ResponseEntity.ok(service.obterPorCpf(cpf));
    }

    @PostMapping
    @Timed
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO usuarioDTO) {
        log.debug("REST request para cadastrar um Usuario");
        return ResponseEntity.ok(service.salvar(usuarioDTO));
    }
}

