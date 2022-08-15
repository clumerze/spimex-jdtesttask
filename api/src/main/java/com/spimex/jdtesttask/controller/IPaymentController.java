package com.spimex.jdtesttask.controller;

import com.spimex.jdtesttask.common.entity.Transaction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/payment")
public interface IPaymentController {
    @PostMapping("/{target}/{amount}")
    void payment(@PathVariable("target") Transaction.Target target, @PathVariable("amount") Integer amount);
}
