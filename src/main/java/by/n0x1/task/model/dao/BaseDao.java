package by.n0x1.task.model.dao;
import java.util.List;

public interface BaseDao<T> {
    List<T> findAll();
    T findById(int id);
    void create(T entity);
    void update(T entity);
    void delete(int id);
}
