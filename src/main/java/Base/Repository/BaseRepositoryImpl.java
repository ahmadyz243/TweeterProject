package Base.Repository;

import Base.Entity.BaseEntity;
import Util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class BaseRepositoryImpl<T extends BaseEntity> implements BaseRepository<T>{
    public EntityManager em = HibernateUtil.getEmf().createEntityManager();
    @Override
    public void save(T t) {
        em.persist(t);
    }
    @Override
    public T update(T t) {
        return em.merge(t);
    }
    @Override
    public void delete(T t) {
        em.remove(t);
    }
    @Override
    public T findById(int id) {
        return em.find(getClassType(), id);
    }

    @Override
    public void beginTransaction() {
        if(!em.getTransaction().isActive()){
            em.getTransaction().begin();
        }
    }

    @Override
    public void commitTransaction() {
        if (em.getTransaction().isActive()){
            em.getTransaction().commit();
        }
    }
}
