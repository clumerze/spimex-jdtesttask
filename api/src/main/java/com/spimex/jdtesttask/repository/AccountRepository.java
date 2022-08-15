package com.spimex.jdtesttask.repository;

import com.spimex.jdtesttask.common.entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
