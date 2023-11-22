package com.example.geektrust.Repository;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.Entities.Loan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LoanAccountManager implements ILoanAccountManager{
    private final HashMap<Customer, List<Loan>> passBook;


    public LoanAccountManager() {
        this.passBook = new HashMap<>();
    }

    @Override
    public void saveCustomer(Customer customer, Loan loan) {
        passBook.computeIfAbsent(customer, k -> new ArrayList<>()).add(loan);


    }

    @Override
    public Loan getLoan(Bank bank, Customer customer) {

        return passBook.get(customer).stream()
                .filter(loan -> loan.getBank().getBankName().equals(bank.getBankName()))
                .findFirst().orElseThrow(RuntimeException::new);
    }
}
