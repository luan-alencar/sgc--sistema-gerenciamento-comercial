package david.augusto.luan.sgc.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "TB_SITUACAO_PRODUTO")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SituacaoProduto implements Serializable {

    private static final long serialVersionUID = 415881688040796203L;

    @Id
    private Integer id;

    @Column(name = "DESCRICAO")
    private String descricao;
}
