package david.augusto.luan.sgc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
    private static final long serialVersionUID = 9008266808251263199L;

    @Id
    @Column
    private Long id;

    @Column
    private String nome;
}
