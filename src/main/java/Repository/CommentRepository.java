package Repository;

import Base.Repository.BaseRepository;
import Entity.Account;
import Entity.Comment;
import Entity.Twitt;

import java.util.List;

public interface CommentRepository extends BaseRepository<Comment> {
    List<Comment> fineAccountCommentsOnTwitt(int accountid, int twittid);
    boolean checkForComment(int accountid, Twitt twitt);
}
