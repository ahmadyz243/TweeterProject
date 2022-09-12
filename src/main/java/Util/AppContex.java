package Util;

import Repository.Impl.AccountRepositoryImpl;
import Repository.Impl.CommentRepositoryImpl;
import Repository.Impl.LikesRepositoryImpl;
import Repository.Impl.TwittRepositoryImpl;
import Service.AccountService;
import Service.CommentService;
import Service.Impl.AccountServiceImpl;
import Service.Impl.CommentServiceImpl;
import Service.Impl.LikesServiceImpl;
import Service.Impl.TwittServiceImpl;
import Service.LikesService;
import Service.TwittService;

public class AppContex {
    public static AccountService accountService = new AccountServiceImpl(new AccountRepositoryImpl());
    public static TwittService twittService = new TwittServiceImpl(new TwittRepositoryImpl());
    public static LikesService likesService = new LikesServiceImpl(new LikesRepositoryImpl());
    public static CommentService commentService = new CommentServiceImpl(new CommentRepositoryImpl());
}
