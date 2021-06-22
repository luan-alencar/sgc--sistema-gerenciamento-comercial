package david.augusto.luan.sgc.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;

    public String primeiroNome;

    public String ultimoNome;

    public String nome;

    private String cpf;

    private String email;

    private String telefone;

    private LocalDate dataNascimento;

    private Boolean isAdmin;

    private String gerarNomeUsuario() {
        if (nome != null && primeiroNome != null) {
            return ((ultimoNome != null) ? ultimoNome : "") + " " + primeiroNome;
        }
        return nome;
    }
}
