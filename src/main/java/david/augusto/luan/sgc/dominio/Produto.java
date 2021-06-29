package david.augusto.luan.sgc.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "TB_PRODUTO")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto implements Serializable {

    private static final long serialVersionUID = 2747267962497450718L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO")
    @SequenceGenerator(name = "SQ_PRODUTO", sequenceName = "SQ_PRODUTO", initialValue = 2, allocationSize = 1)
    private Integer id;

    @Column(name = "DESCRICAO")
    private String descricao;
}
