package com.spimex.jdtesttask.service.payment.handler;

import com.spimex.jdtesttask.common.entity.Payment;

public interface IPipelinePaymentHandler {
    boolean isConditioned(Payment payment);

    void handle(Payment payment);

    boolean isForced();

    Integer getOrder();
}
