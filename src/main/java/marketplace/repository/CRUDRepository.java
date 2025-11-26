package marketplace.repository;


import java.util.List;

public interface CRUDRepository<T> {
    T create(T entity);

    T read(int id);

    void update(T entity);

    boolean delete(int id);

    List<T> readAll(int id);
}
