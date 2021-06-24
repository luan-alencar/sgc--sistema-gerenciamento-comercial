package david.augusto.luan.sgc.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "TB_CATEGORIA")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CATEGORIA")
    @SequenceGenerator(name = "SQ_CATEGORIA", sequenceName = "SQ_CATEGORIA", allocationSize = 1, initialValue = 1)
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

}
