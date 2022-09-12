package Repository.Impl;

import Base.Repository.BaseRepositoryImpl;
import Entity.Account;
import Entity.Likes;
import Repository.LikesRepository;

import java.util.List;

public class LikesRepositoryImpl extends BaseRepositoryImpl<Likes> implements LikesRepository {
    @Override
    public List<Likes> findAll() {
        return em.createQuery("select l from Likes l", Likes.class).getResultList();
    }

    @Override
    public Class<Likes> getClassType() {
        return Likes.class;
    }

    @Override
    public boolean checkForLike(Account account, int twittid) {
        return em.createQuery(
                "select (count(l) > 0) from Likes l where l.twitt.id =: id and l.likerid =: accountid",
                Boolean.class).setParameter("id", twittid).setParameter("accountid", account.getId()).
                getSingleResult();
    }

    @Override
    public Likes findLike(int accountid, int twittid) {
        return em.createQuery("select l from Likes l where l.likerid =: accountid and l.twitt.id =: twittid",
                Likes.class).setParameter("accountid", accountid).setParameter("twittid", twittid).getSingleResult();
    }
}
