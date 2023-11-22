package com.example.geektrust.Entities;

import java.util.Objects;

public class Account {

    private final Integer amount;
    private final Integer emiNumber;

    public Account(Integer amount, Integer emi) {
        this.amount = amount;
        this.emiNumber = emi;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getEmiNumber() {
        return emiNumber;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || (o instanceof Account && equals((Account) o));
    }

    private boolean equals(Account account) {
        return Objects.equals(amount, account.amount) && Objects.equals(emiNumber, account.emiNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, emiNumber);
    }
}
