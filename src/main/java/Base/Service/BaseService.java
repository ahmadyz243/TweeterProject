package Base.Service;

import java.util.List;

public interface BaseService<T> {
    void save(T t);
    T update(T t);
    void delete(T t);
    T findById(int id);
    List<T> findAll();
}
