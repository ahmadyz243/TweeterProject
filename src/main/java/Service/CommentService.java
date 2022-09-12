package Service;

import Base.Service.BaseService;
import Entity.Comment;
import Entity.Twitt;

import java.util.List;

public interface CommentService extends BaseService<Comment> {
    List<Comment> fineAccountCommentsOnTwitt(int accountid, int twittid);
    void printAccountComments(int accountid, int twittid);
    Comment createComment(int accountid, Twitt twitt);
    void commentOnTwitt(int accountid, Twitt twitt);
    void editComment(Comment comment);

    boolean checkForComment(int accountid, Twitt twitt);
}
