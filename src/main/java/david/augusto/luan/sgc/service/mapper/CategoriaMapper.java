package david.augusto.luan.sgc.service.mapper;

import david.augusto.luan.sgc.dominio.Categoria;
import david.augusto.luan.sgc.service.dto.CategoriaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CategoriaMapper extends EntityMapper<CategoriaDTO, Categoria> {

    @Override
    CategoriaDTO toDTO(Categoria entidade);

    @Override
    Categoria toEntity(CategoriaDTO dto);

    @Override
    List<Categoria> toEntityList(List<CategoriaDTO> listDTO);

    @Override
    List<CategoriaDTO> toListDTO(List<Categoria> listEntity);
}
