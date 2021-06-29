package david.augusto.luan.sgc.repository;

import david.augusto.luan.sgc.dominio.Usuario;
import david.augusto.luan.sgc.service.dto.DominioFixoDTO;
import david.augusto.luan.sgc.service.dto.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByCpf(String cpf);

    @Query(value = "SELECT new david.augusto.luan.sgc.service.dto.DominioFixoDTO(u.id,u.cpf)"
            + " FROM Usuario u WHERE u.cpf LIKE concat('%', :cpf,'%')")
    List<DominioFixoDTO> obterPorCpf(@Param("cpf") String cpf);


    @Query(value = "SELECT CASE WHEN count(u) > 0 THEN null ELSE true END "
            + " FROM Usuario u WHERE (u.cpf = :#{#usuarioDTO.cpf}"
            + " OR u.email LIKE LOWER(concat('%', :#{#usuarioDTO.email},'%')))"
            + " AND (:#{#usuarioDTO.id} IS NULL OR u.id != :#{#usuarioDTO.id})")
    Optional<Boolean> findIdsByCpfOrEmail(@Param("usuarioDTO") UsuarioDTO usuarioDTO);

    @Override
    long count();

}