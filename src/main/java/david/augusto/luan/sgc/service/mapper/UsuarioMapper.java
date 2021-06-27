package david.augusto.luan.sgc.service.mapper;

import david.augusto.luan.sgc.dominio.Usuario;
import david.augusto.luan.sgc.service.dto.UsuarioDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {

    @Override
    UsuarioDTO toDTO(Usuario entidade);

    @Override
    Usuario toEntity(UsuarioDTO dto);

    @Override
    List<Usuario> toEntityList(List<UsuarioDTO> listDTO);

    @Override
    List<UsuarioDTO> toListDTO(List<Usuario> listEntity);
}
