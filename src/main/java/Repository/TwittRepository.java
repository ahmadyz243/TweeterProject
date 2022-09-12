package Repository;

import Base.Repository.BaseRepository;
import Entity.Twitt;

import java.util.List;

public interface TwittRepository extends BaseRepository<Twitt> {
    List<Twitt> findAllTwittsByAccountId(int accountid);
    public boolean existsById(int twittid);
}
