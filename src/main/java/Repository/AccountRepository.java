package Repository;

import Base.Repository.BaseRepository;
import Entity.Account;

public interface AccountRepository extends BaseRepository<Account> {
    Account findByUserName(String username);
    boolean existsByUserName(String username);
}
