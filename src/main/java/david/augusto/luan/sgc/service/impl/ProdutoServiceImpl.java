package david.augusto.luan.sgc.service.impl;

import david.augusto.luan.sgc.dominio.Produto;
import david.augusto.luan.sgc.repository.ProdutoRepository;
import david.augusto.luan.sgc.service.ProdutoService;
import david.augusto.luan.sgc.service.dto.ProdutoDTO;
import david.augusto.luan.sgc.service.exceptions.RegraNegocioException;
import david.augusto.luan.sgc.service.impl.utils.ConstantsUtil;
import david.augusto.luan.sgc.service.mapper.ProdutoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static david.augusto.luan.sgc.service.impl.utils.ConstantsUtil.PRODUTO_NAO_EXISTE;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoMapper mapper;
    private final ProdutoRepository repository;

    @Override
    public List<ProdutoDTO> buscarTodos() {
        return mapper.toListDTO(repository.findAll());
    }

    @Override
    public List<ProdutoDTO> obterPoCategoria(Integer idCategoria) {
        return mapper.toListDTO(repository.getProdutosPorCategoria(idCategoria));
    }

    @Override
    public ProdutoDTO salvar(ProdutoDTO entity) {
        Produto produto = mapper.toEntity(entity);

        produto.setIdSituacao(ConstantsUtil.EM_ESTOQUE);
        return mapper.toDTO(repository.save(produto));
    }

    @Override
    public void delete(ProdutoDTO entity) {
        repository.deleteById(entity.getId());
    }

    @Override
    public ProdutoDTO buscarPorId(Integer id) throws RegraNegocioException {
        return mapper.toDTO(repository.findById(id)
                .orElseThrow(() -> new RegraNegocioException(PRODUTO_NAO_EXISTE, "Produto nao encontrado")));
    }

    @Override
    public ProdutoDTO atualizar(ProdutoDTO produtoDTO) throws RegraNegocioException {
        return salvar(produtoDTO);
    }
}
