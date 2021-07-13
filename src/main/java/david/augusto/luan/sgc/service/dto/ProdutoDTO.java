package david.augusto.luan.sgc.service.dto;

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
public class ProdutoDTO {

    private Integer id;

    private String nome;

    private Integer quantidadeMinima;

    private Double valor;

    private SituacaoProduto idSituacao;

    private List<CategoriaDTO> categorias;
}
