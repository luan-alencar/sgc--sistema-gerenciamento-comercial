package david.augusto.luan.sgc.service.impl;

import david.augusto.luan.sgc.service.EntityServiceGeneric;
import david.augusto.luan.sgc.service.dto.UsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements EntityServiceGeneric<UsuarioDTO> {

    @Override
    public List<UsuarioDTO> findAll() {
        return null;
    }

    @Override
    public UsuarioDTO save(UsuarioDTO entity) {
        return null;
    }

    @Override
    public void delete(UsuarioDTO entity) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
