package dao;

import java.util.List;

public interface Dao<T> extends AutoCloseable{

    void add(T obj);
    T findById(int id);
    List<T> findAll();
    void delete(T obj);
    void update(T obj);

}
