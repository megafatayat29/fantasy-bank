package com.pascal.repo;

import com.pascal.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    public Optional<Account> findAccountByUserName(String userName);
    public boolean existsByUserName(String userName);
}
