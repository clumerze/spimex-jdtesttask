package com.spimex.jdtesttask.service.payment;

import com.spimex.jdtesttask.common.entity.Payment;
import com.spimex.jdtesttask.service.payment.handler.IPipelinePaymentHandler;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Component
public class PaymentPipeline {
    private final List<IPipelinePaymentHandler> pipeline;

    @PostConstruct
    public void init() {
        pipeline.sort(Comparator.comparing(IPipelinePaymentHandler::getOrder));
    }

    public Payment accept(Payment payment) {
        for (IPipelinePaymentHandler pipelineHandler : pipeline) {
            if (pipelineHandler.isConditioned(payment)) {
                pipelineHandler.handle(payment);
                if (pipelineHandler.isForced())
                    break;
            }
        }

        return payment;
    }
}
