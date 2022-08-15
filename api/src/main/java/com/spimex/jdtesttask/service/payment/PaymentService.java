package com.spimex.jdtesttask.service.payment;

import com.spimex.jdtesttask.common.entity.Account;
import com.spimex.jdtesttask.common.entity.Payment;
import com.spimex.jdtesttask.common.entity.Transaction;
import com.spimex.jdtesttask.repository.AccountRepository;
import com.spimex.jdtesttask.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@RequiredArgsConstructor
@Transactional
@Service
public class PaymentService {
    private final PaymentPipeline pipeline;
    private final AccountRepository accountRepository;
    private final PaymentRepository paymentRepository;


    @Transactional
    public void doPayment(Transaction.Target target, Integer amount) {
        Payment payment = new Payment(target, amount, accountRepository.findById(1).get());
        pipeline.accept(payment);
        calculate(payment);
        paymentRepository.save(payment);
    }


    private void calculate(Payment payment) {
        Map<Transaction.Target, List<Integer>> sideTransactionsMap = payment.getSideTransactions()
                .stream()
                .collect(Collectors.groupingBy(Transaction::getTarget, Collectors.mapping(Transaction::getAmount, Collectors.toList())));

        Function<Transaction.Target, Integer> reduceAmount = target -> ofNullable(sideTransactionsMap.get(target))
                .map(l -> l.stream().reduce(0, Integer::sum))
                .orElse(0);

        Integer bonuses = reduceAmount.apply(Transaction.Target.BONUS);
        Integer commissions = reduceAmount.apply(Transaction.Target.COMMISSION);
        Integer calculatedAmount = payment.getAmount() + commissions;
        Account account = payment.getAccount();

        switch (payment.getTarget()) {
            case SHOP -> withdrawCash(account, calculatedAmount);
            case ONLINE -> withdrawEMoney(account, calculatedAmount);
        }

        addBonuses(account, bonuses);
    }

    private void withdrawEMoney(Account account, Integer amount) {
        if (account.getEMoney() < amount)
            notEnoughMoney();
        account.setEMoney(account.getEMoney() - amount);
    }

    private void withdrawCash(Account account, Integer amount) {
        if (account.getCash() < amount)
            notEnoughMoney();
        account.setCash(account.getCash() - amount);
    }

    private void addBonuses(Account account, Integer bonuses) {
        account.setBonuses(account.getBonuses() + bonuses);
    }

    private void notEnoughMoney() {
        throw new PaymentServiceException("not enough money");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private class PaymentServiceException extends RuntimeException {
        public PaymentServiceException(String message) {
            super(message);
        }
    }
}
