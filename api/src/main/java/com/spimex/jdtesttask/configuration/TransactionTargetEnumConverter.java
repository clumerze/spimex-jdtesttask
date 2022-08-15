package com.spimex.jdtesttask.configuration;

import com.spimex.jdtesttask.common.entity.Transaction;
import org.springframework.core.convert.converter.Converter;

public class TransactionTargetEnumConverter implements Converter<String, Transaction.Target> {
    @Override
    public Transaction.Target convert(String source) {
        return Transaction.Target.valueOf(source.toUpperCase());
    }
}
