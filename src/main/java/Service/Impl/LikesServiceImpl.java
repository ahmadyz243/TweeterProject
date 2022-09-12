package Service.Impl;

import Base.Service.BaseServiceImpl;
import Entity.Account;
import Entity.Likes;
import Entity.Twitt;
import Repository.LikesRepository;
import Service.LikesService;

public class LikesServiceImpl extends BaseServiceImpl<Likes, LikesRepository> implements LikesService {
    public LikesServiceImpl(LikesRepository repository) {
        super(repository);
    }

    @Override
    public boolean checkForLike(Account account, int twittid) {

        return repository.checkForLike(account, twittid);
    }

    @Override
    public void dissLike(int accountid, Twitt twitt) {
        repository.beginTransaction();
        Likes likes = repository.findLike(accountid, twitt.getId());
        twitt.getLikes().remove(likes);
        repository.delete(likes);
        repository.commitTransaction();
        System.out.println("twitt diss liked...");
    }

    @Override
    public void like(int accountid, Twitt twitt) {
        Likes likes = new Likes(accountid, twitt);
        save(likes);
        twitt.getLikes().add(likes);
        System.out.println("you've liked this twitt...");
    }
}
