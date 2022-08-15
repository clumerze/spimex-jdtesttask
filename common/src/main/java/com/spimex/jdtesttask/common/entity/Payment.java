package com.spimex.jdtesttask.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Payment extends AbstractTransaction {
    @ManyToOne
    @JsonIgnore
    private Account account;
    @OneToMany(mappedBy = "payment", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<SideTransaction> sideTransactions = new ArrayList<>();

    public Payment(Target target, Integer amount, Account account) {
        super(target, amount);
        this.account = account;
    }
}
