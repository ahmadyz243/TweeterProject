package Service;

import Base.Service.BaseService;
import Entity.Account;

public interface AccountService extends BaseService<Account> {
    Account findByUserName(String username);
    Account login();
    Account signup();
    Account createNewAccount();
    void changeNickName(Account account);
    void changeUserName(Account account);
    void changePassword(Account account);
    boolean deleteAccount(Account account);
}
