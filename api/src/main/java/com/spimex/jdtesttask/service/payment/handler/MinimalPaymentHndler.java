package com.spimex.jdtesttask.service.payment.handler;

import com.spimex.jdtesttask.common.entity.Payment;
import com.spimex.jdtesttask.common.entity.SideTransaction;
import com.spimex.jdtesttask.common.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class MinimalPaymentHndler implements IPipelinePaymentHandler {
    @Override
    public boolean isConditioned(Payment payment) {
        return payment.getAmount() < 20;
    }

    @Override
    public void handle(Payment payment) {
        payment.getSideTransactions()
                .add(new SideTransaction(Transaction.Target.COMMISSION, Utils.percent(payment.getAmount(), 10), payment));
    }

    @Override
    public boolean isForced() {
        return true;
    }

    @Override
    public Integer getOrder() {
        return 1;
    }
}
