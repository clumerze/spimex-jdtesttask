package com.spimex.jdtesttask.controller;

import com.spimex.jdtesttask.common.entity.Account;
import com.spimex.jdtesttask.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController implements IAccountController {
    private final AccountService service;

    @Override
    public Account getAccount() {
        return service.getAccount();
    }
}
