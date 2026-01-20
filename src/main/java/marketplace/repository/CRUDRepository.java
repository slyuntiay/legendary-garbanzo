package marketplace.repository;


import marketplace.entity.Entity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CRUDRepository<T extends Entity> {
    T create(T entity);

    Optional<T> read(int id);

    T update(T entity);

    void delete(int id);
}
