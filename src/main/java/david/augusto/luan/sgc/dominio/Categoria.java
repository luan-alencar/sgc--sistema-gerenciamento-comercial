package david.augusto.luan.sgc.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TB_CATEGORIA")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria  {

    @Id
    private Integer id;

    @Column(name = "DESCRICAO")
    private String descricao;

}
