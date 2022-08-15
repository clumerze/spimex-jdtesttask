package com.spimex.jdtesttask.controller;

import com.spimex.jdtesttask.common.entity.Transaction;
import com.spimex.jdtesttask.service.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentController implements IPaymentController {
    private final PaymentService service;

    @Override
    public void payment(Transaction.Target target, Integer amount) {
        service.doPayment(target, amount);
    }
}
