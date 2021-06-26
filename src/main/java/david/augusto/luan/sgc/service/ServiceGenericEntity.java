package david.augusto.luan.sgc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface ServiceGenericEntity<T, Y> {

    List<T> findAll();

    T save(Y entity);

    void delete(T entity);

    void deleteById(Long id);
}
