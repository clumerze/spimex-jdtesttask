package com.spimex.jdtesttask.controller;

import com.spimex.jdtesttask.common.entity.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/bankAccountOfEMoney")
public interface IAccountController {
    @GetMapping
    Account getAccount();
}
