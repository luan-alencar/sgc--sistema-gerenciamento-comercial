package david.augusto.luan.sgc.web.rest;

import david.augusto.luan.sgc.dominio.Produto;
import david.augusto.luan.sgc.service.ProdutoService;
import david.augusto.luan.sgc.service.UsuarioService;
import david.augusto.luan.sgc.service.dto.DominioFixoDTO;
import david.augusto.luan.sgc.service.dto.ProdutoDTO;
import david.augusto.luan.sgc.service.dto.UsuarioDTO;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/produtos")
public class ProdutoResource {

    private final ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> buscarTodosUsuarios() {
        log.debug("REST request para buscar todos Produtos cadastrados");
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable Integer id) {
        log.debug("REST request para buscar Produtos pelo ID");
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/categorias")
    @Timed
    public ResponseEntity<List<ProdutoDTO>> buscarPorCategoria(@PathVariable Integer idCategoria) {
        log.debug("REST request para buscar Produto por Categoria");
        return ResponseEntity.ok(service.obterPoCategoria(idCategoria));
    }

    @PostMapping("/salvar")
    @Timed
    public ResponseEntity<ProdutoDTO> salvar(@RequestBody ProdutoDTO produtoDTO) {
        log.debug("REST request para cadastrar um Produto");
        return ResponseEntity.ok(service.salvar(produtoDTO));
    }
}

