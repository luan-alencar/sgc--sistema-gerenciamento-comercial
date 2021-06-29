package david.augusto.luan.sgc.service;

import david.augusto.luan.sgc.service.exceptions.RegraNegocioException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface ServiceGenericEntity<T> {

    List<T> buscarTodos();

    T salvar(T entity);

    void delete(T entity);

    T buscarPorId(Integer id) throws RegraNegocioException;
}
