package david.augusto.luan.sgc.service.dto;

import david.augusto.luan.sgc.dominio.Categoria;
import david.augusto.luan.sgc.dominio.SituacaoProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO implements Serializable {

    private Integer id;

    private String nome;

    private Integer quantidadeMinima;

    private Double valor;

    private SituacaoProdutoDTO idSituacao;

    private List<CategoriaDTO> categoria;
}
