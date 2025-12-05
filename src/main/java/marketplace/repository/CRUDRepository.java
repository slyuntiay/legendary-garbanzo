package marketplace.repository;


import java.util.List;

public interface CRUDRepository<T> {
    void createTable();

    void dropTable();

    T create(T entity);

    T read(int id);

    void update(T entity);

    void delete(int id);

    List<T> readAll();
}
