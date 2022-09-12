package Service.Impl;

import Base.Service.BaseServiceImpl;
import Entity.Comment;
import Entity.Twitt;
import Repository.CommentRepository;
import Service.CommentService;
import Util.Menu;

import javax.persistence.NoResultException;
import java.util.List;

public class CommentServiceImpl extends BaseServiceImpl<Comment, CommentRepository> implements CommentService {

    public CommentServiceImpl(CommentRepository repository) {
        super(repository);
    }

    @Override
    public List<Comment> fineAccountCommentsOnTwitt(int accountid, int twittid) {
        try {
            return repository.fineAccountCommentsOnTwitt(accountid, twittid);
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void printAccountComments(int accountid, int twittid) {
        fineAccountCommentsOnTwitt(accountid, twittid).forEach(comment ->
                System.out.println("writer ID: " + comment.getWriterid() +
                        "    comment ID:  " + comment.getId() +
                        "   " + comment.getText()));
    }

    @Override
    public Comment createComment(int accountid, Twitt twitt) {
        System.out.println("enter your comment:");
        String commentText = Menu.lineScanner();
        return new Comment(commentText, accountid, twitt);
    }

    @Override
    public void commentOnTwitt(int accountid, Twitt twitt) {
        repository.beginTransaction();
        Comment comment = createComment(accountid, twitt);
        save(comment);
        twitt.getComments().add(comment);
        repository.commitTransaction();
        System.out.println("comment saved...");
    }

    @Override
    public void editComment(Comment comment) {
        System.out.println("enter your new comment:");
        String newcomment = Menu.lineScanner();
        repository.beginTransaction();
        comment.setText(newcomment);
        repository.commitTransaction();
        System.out.println("comment changed...");
    }

    @Override
    public boolean checkForComment(int accountid, Twitt twitt) {
        return repository.checkForComment(accountid, twitt);
    }
}
