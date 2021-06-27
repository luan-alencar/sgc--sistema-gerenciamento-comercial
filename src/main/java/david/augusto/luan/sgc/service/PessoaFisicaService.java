package david.augusto.luan.sgc.service;

import org.springframework.stereotype.Component;

@Component
public interface PessoaFisicaService {

    String consultarNomePorCPF(String cpf);
}
