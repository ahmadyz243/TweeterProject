package Base.Service;

import Base.Entity.BaseEntity;
import Base.Repository.BaseRepository;

import java.util.List;

public abstract class BaseServiceImpl<T extends BaseEntity, R extends BaseRepository<T>> implements BaseService<T> {
    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    protected R repository;

    @Override
    public void save(T t) {
        repository.beginTransaction();
        repository.save(t);
        repository.commitTransaction();
    }

    @Override
    public T update(T t) {
        repository.beginTransaction();
        T t1 = repository.update(t);
        repository.commitTransaction();
        return t1;
    }

    @Override
    public void delete(T t) {
        repository.beginTransaction();
        repository.delete(t);
        repository.commitTransaction();
    }

    @Override
    public T findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
}
