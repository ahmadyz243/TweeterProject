package Service;

import Base.Service.BaseService;
import Entity.Account;
import Entity.Likes;
import Entity.Twitt;

public interface LikesService extends BaseService<Likes> {
    boolean checkForLike(Account account, int twittid);
    void dissLike(int accountid, Twitt twitt);
    void like(int accountid, Twitt twitt);
}
