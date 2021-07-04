package david.augusto.luan.sgc.repository;

import david.augusto.luan.sgc.dominio.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {


    @Query("SELECT new david.augusto.luan.sgc.service.dto.CategoriaDTO(up.id, up.descricao)"
            + " FROM Produto p INNER JOIN p.categorias up"
            + " WHERE p.id = :idProduto AND up.id = :idCategoria")
    List<Produto> getProdutosPorCategoria(@Param("idProduto") Integer idProduto,
                                             @Param("idCategoria") Integer idCategoria);

}
