package com.spimex.jdtesttask.service.payment.handler;

import com.spimex.jdtesttask.common.entity.Payment;
import com.spimex.jdtesttask.common.entity.SideTransaction;
import com.spimex.jdtesttask.common.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class OnlinePurchasePaymentHandler implements IPipelinePaymentHandler {

    @Override
    public boolean isConditioned(Payment payment) {
        return payment.getTarget()
                .equals(Transaction.Target.ONLINE);
    }

    @Override
    public void handle(Payment payment) {
        payment.getSideTransactions()
                .add(new SideTransaction(Transaction.Target.BONUS, Utils.percent(payment.getAmount(), 17), payment));
    }

    @Override
    public boolean isForced() {
        return false;
    }

    @Override
    public Integer getOrder() {
        return 2;
    }
}
