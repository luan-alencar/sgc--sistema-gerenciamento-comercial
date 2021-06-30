package david.augusto.luan.sgc.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "TB_USUARIO")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {

    private static final long serialVersionUID = -3591529614279292916L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
    @SequenceGenerator(name = "SQ_USUARIO", sequenceName = "SQ_USUARIO", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name = "PRIMEIRO_NOME")
    public String primeiroNome;

    @Column(name = "SEGUNDO_NOME")
    public String ultimoNome;

    @Column(name = "NOME")
    public String nome;

    @Column(name = "CPF")
    @Size(max = 11, min = 11)
    private String cpf;

    @Column(name = "EMAIL")
    @Email
    private String email;

    @Column(name = "TELEFONE")
    @Size(max = 15)
    private String telefone;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Column(name = "CHAVE_ACESSO")
    private String chaveUnica;

    @Column(name = "IS_ADMIN")
    private Boolean isAdmin;

    private String gerarNomeUsuario() {
        if (nome != null && primeiroNome != null) {
            return ((ultimoNome != null) ? ultimoNome : "") + " " + primeiroNome;
        }
        return nome;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}

