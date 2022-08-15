package com.spimex.jdtesttask.service.payment.handler;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {
    public static Integer percent(Integer amount, Integer percent) {
        return new BigDecimal(amount)
                .divide(BigDecimal.valueOf(100), 1, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(percent))
                .setScale(0, RoundingMode.HALF_UP)
                .intValue();
    }
}
