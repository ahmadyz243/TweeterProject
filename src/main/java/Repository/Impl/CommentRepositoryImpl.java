package Repository.Impl;

import Base.Repository.BaseRepository;
import Base.Repository.BaseRepositoryImpl;
import Entity.Comment;
import Entity.Twitt;
import Repository.CommentRepository;

import java.util.List;

public class CommentRepositoryImpl extends BaseRepositoryImpl<Comment> implements CommentRepository {
    @Override
    public List<Comment> findAll() {
        return em.createQuery("select c from Comment c", Comment.class).getResultList();
    }

    @Override
    public Class<Comment> getClassType() {
        return Comment.class;
    }

    @Override
    public List<Comment> fineAccountCommentsOnTwitt(int accountid, int twittid) {
        return em.createQuery("select c from Comment c where c.writerid =: accountid " +
                "and c.twitt.id =: twittid", Comment.class).setParameter("accountid", accountid)
                .setParameter("twittid", twittid).getResultList();
    }

    @Override
    public boolean checkForComment(int accountid, Twitt twitt) {
        return em.createQuery(
                        "select (count(c) > 0) from Comment c where c.twitt.id =: id and c.writerid =: accountid",
                        Boolean.class).setParameter("id", twitt.getId()).setParameter("accountid", accountid).
                getSingleResult();
    }
}
