package Service;

import Base.Service.BaseService;
import Entity.Account;
import Entity.Twitt;

public interface TwittService extends BaseService<Twitt> {
    Twitt createNewTweet(Account account);
    void publishNewTwitt(Account account);
    void viewMyTwitts(Account account);
    void viewAndEditTwit(Account account);
    void editTwitt(Twitt twitt);
    void askForRePublish(Twitt twitt);
    void viewAllTwitts(Account account);

}
