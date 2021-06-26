package david.augusto.luan.sgc.repository;

import david.augusto.luan.sgc.dominio.Usuario;
import david.augusto.luan.sgc.service.dto.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT NEW david.augusto.luan.sgc.service.dto.UsuarioDTO(usuarioPorEmail.id, usuarioPorEmail.email)"
            + " FROM Usuario usuarioPorEmail WHERE LOWER(usuarioPorEmail.email) LIKE LOWER(CONCAT('%', :nome, '%'))")
    Usuario obterPorEmail(String email);

    @Query(value = "SELECT NEW david.augusto.luan.sgc.service.dto.UsuarioDTO(cpfUsuario.id,u.cpfUsuario)"
            + " FROM Usuario cpfUsuario WHERE cpfUsuario.cpf LIKE concat('%', :cpf,'%')")
    Usuario obterPorCPF(String cpf);

    @Query(value = "SELECT new david.augusto.luan.sgc.service.dto.UsuarioDTO(u.id, u.cpf)"
            + " FROM Usuario u WHERE LOWER(u.nome) LIKE lower(concat('%', :nome,'%'))")
    List<UsuarioDTO> obterPorNome(@Param("nome") String nome);

    @Override
    long count();

    Usuario findByChaveUnica(String chave);
}
