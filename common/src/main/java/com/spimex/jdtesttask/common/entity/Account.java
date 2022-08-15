package com.spimex.jdtesttask.common.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account extends AbstractEntityWithoutNaturalId {
    private Integer cash;
    private Integer eMoney;
    private Integer bonuses;
    @OneToMany(mappedBy = "account", orphanRemoval = true, cascade = {CascadeType.ALL})
    private List<Payment> paymentHistory;

    public Account(Integer cash, Integer eMoney, Integer bonuses) {
        this.cash = cash;
        this.eMoney = eMoney;
        this.bonuses = bonuses;
    }
}
