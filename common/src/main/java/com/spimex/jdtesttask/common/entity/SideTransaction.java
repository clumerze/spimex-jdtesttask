package com.spimex.jdtesttask.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SideTransaction extends AbstractTransaction {
    @ManyToOne
    @JsonIgnore
    private Payment payment;

    public SideTransaction(Target target, Integer amount, Payment payment) {
        super(target, amount);
        this.payment = payment;
    }
}
