package david.augusto.luan.sgc.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;

    @NotBlank
    public String primeiroNome;

    @NotBlank
    public String ultimoNome;

    @NotEmpty
    public String nome;

    @NotBlank
    @CPF
    private String cpf;

    @Email
    private String email;

    @NotBlank
    private String telefone;

    @NotBlank
    private LocalDate dataNascimento;

    private Boolean isAdmin;

    private String gerarNomeUsuario() {
        if (nome != null && primeiroNome != null) {
            return ((ultimoNome != null) ? ultimoNome : "") + " " + primeiroNome;
        }
        return nome;
    }
}
