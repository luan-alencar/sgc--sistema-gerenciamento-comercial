package david.augusto.luan.sgc.service;

import david.augusto.luan.sgc.dominio.Categoria;
import david.augusto.luan.sgc.service.dto.DominioFixoDTO;
import david.augusto.luan.sgc.service.dto.ProdutoDTO;
import david.augusto.luan.sgc.service.dto.UsuarioDTO;
import david.augusto.luan.sgc.service.exceptions.RegraNegocioException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface ProdutoService extends ServiceGenericEntity<ProdutoDTO> {

    @Override
    List<ProdutoDTO> buscarTodos();

    List<Categoria> obterPoCategoria(Integer idCategoria);

    @Override
    ProdutoDTO salvar(ProdutoDTO entity);

    @Override
    void delete(ProdutoDTO entity);

    @Override
    ProdutoDTO buscarPorId(Integer id) throws RegraNegocioException;
}