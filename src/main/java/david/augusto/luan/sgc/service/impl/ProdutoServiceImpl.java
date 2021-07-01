package david.augusto.luan.sgc.service.impl;

import david.augusto.luan.sgc.dominio.Categoria;
import david.augusto.luan.sgc.service.ProdutoService;
import david.augusto.luan.sgc.service.dto.ProdutoDTO;
import david.augusto.luan.sgc.service.exceptions.RegraNegocioException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProdutoServiceImpl implements ProdutoService {

    @Override
    public List<ProdutoDTO> buscarTodos() {
        return null;
    }

    @Override
    public List<Categoria> obterPoCategoria(Integer idCategoria) {
        return null;
    }

    @Override
    public ProdutoDTO salvar(ProdutoDTO entity) {
        return null;
    }

    @Override
    public void delete(ProdutoDTO entity) {

    }

    @Override
    public ProdutoDTO buscarPorId(Integer id) throws RegraNegocioException {
        return null;
    }

    @Override
    public ProdutoDTO atualizar(Integer id) throws RegraNegocioException {
        return null;
    }
}
