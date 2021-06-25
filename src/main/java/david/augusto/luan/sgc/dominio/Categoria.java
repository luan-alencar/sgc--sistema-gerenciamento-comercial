package david.augusto.luan.sgc.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "TB_CATEGORIA")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria  implements Serializable {

    private static final long serialVersionUID = 4371679100150120121L;

    @Id
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

}
