package Repository;

import Base.Repository.BaseRepository;
import Entity.Account;
import Entity.Likes;

public interface LikesRepository extends BaseRepository<Likes> {
    boolean checkForLike(Account account, int twittid);
    Likes findLike(int accountid, int twittid);
}
