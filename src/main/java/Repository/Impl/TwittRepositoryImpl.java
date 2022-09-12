package Repository.Impl;

import Base.Repository.BaseRepositoryImpl;
import Entity.Twitt;
import Repository.TwittRepository;

import java.util.List;

public class TwittRepositoryImpl extends BaseRepositoryImpl<Twitt> implements TwittRepository {
    @Override
    public List<Twitt> findAll() {
        return em.createQuery("select t from Twitt t", Twitt.class).getResultList();
    }

    @Override
    public Class<Twitt> getClassType() {
        return Twitt.class;
    }

    @Override
    public List<Twitt> findAllTwittsByAccountId(int accountid) {
        return em.createQuery("select t from Twitt t where t.account.id =: accountid order by t.zonedDateTime"
                        , Twitt.class)
                .setParameter("accountid", accountid).getResultList();
    }

    @Override
    public boolean existsById(int twittid) {
        return em.createQuery("select (count(t) > 0) from Twitt t where t.id =: twittid", Boolean.class)
                .setParameter("twittid", twittid).getSingleResult();
    }
}
