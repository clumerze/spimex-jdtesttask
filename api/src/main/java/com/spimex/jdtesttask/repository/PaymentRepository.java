package com.spimex.jdtesttask.repository;

import com.spimex.jdtesttask.common.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}
