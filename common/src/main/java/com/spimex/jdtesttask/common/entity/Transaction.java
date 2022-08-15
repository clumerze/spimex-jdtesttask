package com.spimex.jdtesttask.common.entity;

public interface Transaction {

    Target getTarget();

    Integer getAmount();


    enum Target {
        SHOP,
        ONLINE,
        BONUS,
        COMMISSION
    }
}
