package david.augusto.luan.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioDTO {

    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private String telefone;

    private LocalDate dataNascimento;
}
