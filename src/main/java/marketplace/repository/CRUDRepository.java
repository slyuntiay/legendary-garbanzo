package marketplace.repository;


import marketplace.entity.Entity;

import java.util.List;

public interface CRUDRepository<T extends Entity> {
    void createTable();

    void dropTable();

    T create(T entity);

    T read(int id);

    void update(T entity);

    void delete(int id);

    List<T> readAll();
}
