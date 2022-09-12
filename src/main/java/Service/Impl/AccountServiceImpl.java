package Service.Impl;

import Base.Service.BaseServiceImpl;
import Entity.Account;
import Repository.AccountRepository;
import Service.AccountService;
import Util.Menu;

import javax.persistence.NoResultException;
import java.util.Objects;

public class AccountServiceImpl extends BaseServiceImpl<Account, AccountRepository> implements AccountService {
    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
    }

    @Override
    public Account findByUserName(String username) {
        try {
            return repository.findByUserName(username);
        } catch (NoResultException e) {
            System.out.println("Account doesn't exists!!!");
            return null;
        }
    }

    @Override
    public Account login() {
        Account account = null;
        String pass = "";
        while (account == null) {
            Menu.printEnterUserName();
            account = findByUserName(Menu.stringScanner());
        }
        while (!Objects.equals(account.getPassword(), pass)) {
            Menu.printEnterPassWord();
            pass = Menu.stringScanner();
            if (!Objects.equals(account.getPassword(), pass)) {
                System.out.println("wrong password!!!");
            } else {
                System.out.println("login success...");
            }
        }
        System.out.println("welcome " + account.getNickname());
        return account;
    }

    @Override
    public Account signup() {
        Account account = createNewAccount();
        save(account);
        System.out.println("signup success...");
        return account;
    }

    @Override
    public Account createNewAccount() {
        String username = "", password, passwordrepeat = "";
        System.out.println("choose a nickname:");
        String nickname = Menu.stringScanner();
        while (true) {
            Menu.printEnterUserName();
            username = Menu.stringScanner();
            if (repository.existsByUserName(username)) {
                System.out.println("this username is already exists. try a different usename:");
            } else {
                break;
            }
        }
        while (true) {
            Menu.printEnterPassWord();
            password = Menu.stringScanner();
            if (password.isBlank() || password.isEmpty()) {
                System.out.println("invalid password!!!");
            } else {
                break;
            }
        }
        while (!Objects.equals(passwordrepeat, password)) {
            System.out.println("repeat password:");
            passwordrepeat = Menu.stringScanner();
            if (!Objects.equals(passwordrepeat, password)) {
                System.out.println("wrong!");
            }
        }
        return new Account(nickname, username, password);
    }

    @Override
    public void changeNickName(Account account) {
        System.out.println("enter your new nickname:");
        String nickname = "";
        while (nickname.isEmpty() || nickname.isBlank()) {
            nickname = Menu.stringScanner();
        }
        repository.beginTransaction();
        account.setNickname(nickname);
        repository.commitTransaction();
        System.out.println("nickname changed...");
    }

    @Override
    public void changeUserName(Account account) {
        System.out.println("enter your new username:");
        String username = "";
        while (true) {
            username = Menu.stringScanner();
            if (!repository.existsByUserName(username)) {
                repository.beginTransaction();
                account.setUsername(username);
                repository.commitTransaction();
                System.out.println("username changed...");
                break;
            } else {
                System.out.println("this username already exists!!!");
            }
        }
    }

    @Override
    public void changePassword(Account account) {
        System.out.println("enter your new password:");
        String password = "", repeatpass = "";
        while (password.isEmpty() || password.isBlank()) {
            password = Menu.stringScanner();
        }
        while (!Objects.equals(repeatpass, password)){
            System.out.println("repeat password");
            repeatpass = Menu.stringScanner();
            if(!Objects.equals(repeatpass, password)){
                System.out.println("wrong!!!");
            }
        }
        repository.beginTransaction();
        account.setPassword(password);
        repository.commitTransaction();
        System.out.println("password changed...");
    }

    @Override
    public boolean deleteAccount(Account account) {
        System.out.println("are you sure you want to delete your account?");
        System.out.println("1. cancel:");
        System.out.println("2. yes:");
        int selection = 0;
        String password;
        while (selection < 1 || selection > 2){
            selection = Menu.numberScanner();
        }
        if(selection == 2){
            delete(account);
            System.out.println("account deleted...");
            return true;
        }
        return false;
    }
}

