package david.augusto.luan.sgc.service;

import david.augusto.luan.sgc.dominio.Usuario;
import david.augusto.luan.sgc.service.dto.UsuarioDTO;

public interface UsuarioGenericEntity {

    UsuarioDTO save(Usuario usuario);

}
