package david.augusto.luan.sgc.service.mapper;

import java.util.List;

/**
 * Contrato para a entidade de mapeamento generica DTO
 *
 * @param <D> parametro tipo DTO
 * @param <E> parametro tipo ENTIDADE
 */

public interface EntityMapper<D, E> {

    // Converte para DTO
    D toDTO(E entidade);

    // Converte para entidade
    E toEntity(D dto);

    // Converte para uma lista de entidades
    List<E> toEntityList(List<D> listDTO);

    // Converte para uma lista de DTO's
    List<D> toListDTO(List<E> listEntity);
}
