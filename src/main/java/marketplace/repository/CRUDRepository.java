package marketplace.repository;

import java.util.List;

public interface CRUDRepository<T> {

    T create(T entity);
    T read(int id);
    T update(T entity);
    boolean delete(int id);
    List<T> readAll();

}
