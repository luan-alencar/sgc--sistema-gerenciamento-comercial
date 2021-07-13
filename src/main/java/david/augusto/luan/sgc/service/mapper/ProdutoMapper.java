package david.augusto.luan.sgc.service.mapper;

import david.augusto.luan.sgc.dominio.Produto;
import david.augusto.luan.sgc.service.dto.ProdutoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface ProdutoMapper extends EntityMapper<ProdutoDTO, Produto> {

    @Override
    ProdutoDTO toDTO(Produto entidade);

    @Override
    Produto toEntity(ProdutoDTO dto);

    @Override
    List<Produto> toEntityList(List<ProdutoDTO> listDTO);

    @Override
    List<ProdutoDTO> toListDTO(List<Produto> listEntity);
}
