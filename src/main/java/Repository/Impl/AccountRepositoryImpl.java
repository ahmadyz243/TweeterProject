package Repository.Impl;

import Base.Repository.BaseRepositoryImpl;
import Entity.Account;
import Repository.AccountRepository;

import java.util.List;

public class AccountRepositoryImpl extends BaseRepositoryImpl<Account> implements AccountRepository {
    @Override
    public List<Account> findAll() {
        return em.createQuery("select a from Account a", Account.class).getResultList();
    }

    @Override
    public Class<Account> getClassType() {
        return Account.class;
    }

    @Override
    public Account findByUserName(String username) {
        return em.createQuery("select a from Account a where a.username =: username", Account.class)
                .setParameter("username", username).getSingleResult();
    }

    @Override
    public boolean existsByUserName(String username) {
        return em.createQuery("select (count(a) > 0) from Account a where a.username =: username", Boolean.class)
                .setParameter("username", username).getSingleResult();
    }
}
