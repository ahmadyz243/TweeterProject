package Service.Impl;

import Base.Service.BaseServiceImpl;
import Entity.Account;
import Entity.Comment;
import Entity.Twitt;
import Repository.TwittRepository;
import Service.TwittService;
import Util.AppContex;
import Util.Menu;

import java.time.ZonedDateTime;
import java.util.List;

public class TwittServiceImpl extends BaseServiceImpl<Twitt, TwittRepository> implements TwittService {

    public TwittServiceImpl(TwittRepository repository) {
        super(repository);
    }

    @Override
    public Twitt createNewTweet(Account account) {
        Twitt twitt = new Twitt();
        System.out.println("add title:");
        twitt.setTitle(Menu.lineScanner());
        while (true) {
            System.out.println("write your text(your text's length should not be more than 280 characters):");
            twitt.setText(Menu.lineScanner());
            if (twitt.getText().length() <= 280) {
                break;
            } else {
                System.out.println("your text's length should not be more than 280 characters");
            }
        }
        twitt.setAccount(account);
        twitt.setZonedDateTime(ZonedDateTime.now());
        return twitt;
    }

    @Override
    public void publishNewTwitt(Account account) {
        save(createNewTweet(account));
        System.out.println("twitt published...");
    }

    @Override
    public void viewMyTwitts(Account account) {
        List<Twitt> twitts = repository.findAllTwittsByAccountId(account.getId());
        twitts.forEach(twitt -> System.out.println(
                twitt.getId() + ".  " + twitt.getTitle() + "   " + twitt.getText()));
    }

    @Override
    public void viewAndEditTwit(Account account) {
        int id, selection = 0;
        Twitt twitt;
        viewMyTwitts(account);
        while (true) {
            System.out.println("enter twitt id to select:");
            id = Menu.numberScanner();
            if (repository.existsById(id)) {
                twitt = findById(id);
                if (account.getId() == twitt.getAccount().getId()) {
                    Menu.printTwittAction();
                    selection = Menu.selectTwittAction();
                    switch (selection) {
                        case 1: editTwitt(twitt);
                        break;
                        case 2: delete(twitt);
                            System.out.println("twitt deleted");
                        break;
                        case 3: // back
                            break;
                    }
                    break;
                } else {
                    System.out.println("invalid id");
                }
            } else {
                System.out.println("invalid id!!!");
            }
        }
    }

    @Override
    public void editTwitt(Twitt twitt) {
        Menu.printEditTwittMenu();
        int selection = Menu.selectEditTwittMenu();
        if(selection == 1){             // edit title
            System.out.println("enter new title");
            repository.beginTransaction();
            twitt.setTitle(Menu.lineScanner());
            repository.commitTransaction();
            System.out.println("title changed...");
            askForRePublish(twitt);
        } else if (selection == 2) {    // edit text
            System.out.println("enter new text");
            repository.beginTransaction();
            twitt.setText(Menu.lineScanner());
            repository.commitTransaction();
            System.out.println("text changed...");
            askForRePublish(twitt);
        }else {                         // back

        }
    }

    @Override
    public void askForRePublish(Twitt twitt) {
        System.out.println("republish ?");
        System.out.println("1. yes");
        System.out.println("2. no");
        int selection = Menu.selectTwoOption();
        if (selection == 1){
            repository.beginTransaction();
            twitt.setZonedDateTime(ZonedDateTime.now());
            repository.commitTransaction();
        }
    }

    @Override
    public void viewAllTwitts(Account account) {
        int id;
        Twitt twitt;
        List<Twitt> twitts = findAll();
        twitts.forEach(twittt -> System.out.println(
                twittt.getId() + ".  " + twittt.getTitle() + "   " + twittt.getText()));
        while (true){
            System.out.println("select a twitt by ID to view:");
            id = Menu.numberScanner();
            if(repository.existsById(id)){
                twitt = findById(id);
                System.out.println(twitt.getTitle());
                System.out.println(twitt.getText());
                System.out.println("created in:   " + twitt.getZonedDateTime());
                System.out.println(twitt.getLikes().size() + " likes & " +
                        twitt.getComments().size() + " comments");
                AppContex.commentService.printAccountComments(account.getId(), id);
                if(AppContex.likesService.checkForLike(account, id)){
                    System.out.println("you,ve liked this twitt");
                    System.out.println("1. dissLike:");
                }else{
                    System.out.println("1. Like:");
                }
                System.out.println("2. add comment on this twitt:");
                System.out.println("3. edit or delete comment on this twitt:");
                System.out.println("4. view all comments:");
                int selection = Menu.selectFourOption();
                Comment comment ;
                if(selection == 2){
                    AppContex.commentService.commentOnTwitt(account.getId(), twitt);
                } else if (selection == 3) {

                    if(!AppContex.commentService.checkForComment(account.getId(), twitt)){
                        System.out.println("you have no comment on this post");
                    }else {
                        AppContex.commentService.printAccountComments(account.getId(), id);
                        while (true){
                            System.out.println("enter comment id to select:");
                            comment = AppContex.commentService.findById(Menu.numberScanner());
                            if(comment == null || comment.getWriterid() != account.getId()){
                                System.out.println("wrong input!!!");
                            }else {
                                editOrDeleteComments(comment, twitt);
                                break;
                            }
                        }
                    }
                } else if (selection == 4) {
                    twitt.getComments().forEach(comment1 ->
                            System.out.println("user ID: " + comment1.getWriterid() +
                                    "  " + comment1.getText()));
                    break;
                } else{
                    if(AppContex.likesService.checkForLike(account, id)){
                        AppContex.likesService.dissLike(account.getId(), twitt);
                        break;
                    }else {
                        AppContex.likesService.like(account.getId(), twitt);
                        break;
                    }
                }
                break;
            }else {
                System.out.println("invalid id!!!");
            }
        }
    }

    private void editOrDeleteComments(Comment comment, Twitt twitt) {
        int selection;
        Menu.printEditOrDeleteCommentMenu();
        selection = Menu.selectTwoOption();
        if(selection == 1){
            AppContex.commentService.delete(comment);
            twitt.getComments().remove(comment);
            System.out.println("comment deleted...");
        }else {
            AppContex.commentService.editComment(comment);
        }
    }


}
