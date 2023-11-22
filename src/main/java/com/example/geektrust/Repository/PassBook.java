package com.example.geektrust.Repository;

import com.example.geektrust.Entities.Account;
import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.Entities.Loan;


public class PassBook implements IPassBook {
    private final ILoanAccountManager loanAccountManager;
    private final IPaymentManager paymentManager;

    public PassBook(ILoanAccountManager loanAccountManager, IPaymentManager paymentManager) {
        this.loanAccountManager = loanAccountManager;
        this.paymentManager = paymentManager;
    }

    @Override
    public void updateAccount(Customer customer, Bank bank, Account account) {
        paymentManager.updateAccount(customer, bank, account);
    }

    @Override
    public void saveCustomer(Customer customer, Loan loan) {
        loanAccountManager.saveCustomer(customer, loan);
    }

    @Override
    public Loan getLoan(Bank bank, Customer customer) {
        return loanAccountManager.getLoan(bank, customer);
    }

}
