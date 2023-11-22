package com.example.geektrust.Entities;

import java.util.List;


public class Loan {

    private final Bank bank;
    private final Customer customer;
    private final Installment installment;
    private final Double totalAmountToPay;
    private final AccountManager accountManager;

    public Loan(Bank bank, Customer customer, Installment installment, Double totalAmountToPay) {
        this.bank = bank;
        this.customer = customer;
        this.installment = installment;
        this.totalAmountToPay = totalAmountToPay;
        this.accountManager = new AccountManager();
    }

    public Bank getBank() {
        return bank;
    }

    public Customer getBorrower() {
        return customer;
    }

    public Integer getInstallmentCost() {
        return installment.getInstallmentAmount();
    }

    public Double getTotalAmountToPay() {
        return totalAmountToPay;
    }

    public void addAccount(Account account) {
        accountManager.addAccount(account);
    }

    public List<Account> getLumpSumBeforeInstallment(Integer currentEmiCount) {
        return accountManager.getLumpSumBeforeInstallment(currentEmiCount);
    }

    public Boolean isAccountBeforeInstallment(Integer currentEmiCount) {
        return accountManager.isAccountBeforeInstallment(currentEmiCount);
    }
}
