package com.spimex.jdtesttask.service;

import com.spimex.jdtesttask.common.entity.Account;
import com.spimex.jdtesttask.repository.AccountRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    @PostConstruct
    @Transactional(readOnly = true)
    public void init() {
        accountRepository.save(new Account(5000, 5000, 0));
    }

    public Account getAccount() {
        return accountRepository.findById(1)
                .get();
    }
}
