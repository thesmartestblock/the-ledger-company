package com.example.geektrust.Repository;

import com.example.geektrust.Entities.Account;
import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.Entities.Loan;

public class PaymentManager implements IPaymentManager {
    private final ILoanAccountManager loanAccountManager;

    public PaymentManager(ILoanAccountManager loanAccountManager) {
        this.loanAccountManager = loanAccountManager;
    }


    @Override
    public void updateAccount(Customer customer, Bank bank, Account account) {

        Loan loan = loanAccountManager.getLoan(bank, customer);

        loan.addAccount(account);

    }
}
