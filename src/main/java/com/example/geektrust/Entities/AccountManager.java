package com.example.geektrust.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountManager {

    private final List<Account> accountPayments;

    public AccountManager() {
        this.accountPayments = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accountPayments.add(account);
    }

    public List<Account> getLumpSumBeforeInstallment(Integer currentEmiCount) {
        return accountPayments.stream()
                .filter(payment -> payment.getEmiNumber() <= currentEmiCount)
                .collect(Collectors.toList());
    }

    public Boolean isAccountBeforeInstallment(Integer currentEmiCount) {
        return accountPayments.stream()
                .anyMatch(check -> check.getEmiNumber() <= currentEmiCount);
    }

}
