package Base.Repository;

import java.util.List;

public interface BaseRepository<T> {

    void save(T t);
    T update(T t);
    void delete(T t);
    T findById(int id);
    List<T> findAll();
    void beginTransaction();
    void commitTransaction();
    Class<T> getClassType();

}
