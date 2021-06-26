package david.augusto.luan.sgc.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmailDTO {

    private String destinatario;

    private String corpo;

    private String assunto;

    private List<String> copias;

}
