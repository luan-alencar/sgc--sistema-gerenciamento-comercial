package david.augusto.luan.sgc.service.mapper;

import david.augusto.luan.sgc.dominio.SituacaoProduto;
import david.augusto.luan.sgc.service.dto.SituacaoProdutoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SituacaoProdutoMapper extends EntityMapper<SituacaoProdutoDTO, SituacaoProduto> {

    @Override
    SituacaoProdutoDTO toDTO(SituacaoProduto entidade);

    @Override
    SituacaoProduto toEntity(SituacaoProdutoDTO dto);

    @Override
    List<SituacaoProduto> toEntityList(List<SituacaoProdutoDTO> listDTO);

    @Override
    List<SituacaoProdutoDTO> toListDTO(List<SituacaoProduto> listEntity);
}
