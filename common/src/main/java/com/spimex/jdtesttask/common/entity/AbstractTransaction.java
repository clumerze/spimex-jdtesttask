package com.spimex.jdtesttask.common.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class AbstractTransaction
        extends AbstractEntityWithoutNaturalId
        implements Transaction {
    @Enumerated(EnumType.STRING)
    private Target target;
    private Integer amount;

    public AbstractTransaction(Target target, Integer amount) {
        this.target = target;
        this.amount = amount;
    }
}
