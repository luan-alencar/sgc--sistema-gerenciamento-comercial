package david.augusto.luan.sgc.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private Integer id;

    @NotBlank
    public String primeiroNome;

    @NotBlank
    public String ultimoNome;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    private String email;

    @NotBlank
    private String telefone;

    @NotBlank
    private LocalDate dataNascimento;

    private Boolean isAdmin;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
