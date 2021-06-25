package david.augusto.luan.sgc.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntityServiceGeneric<T> {

    List<T> findAll();

    T save(T entity);

    void delete(T entity);

    void deleteById(Long id);
}
