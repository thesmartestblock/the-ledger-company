package com.example.geektrust.Repository;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.Entities.Loan;
import com.example.geektrust.Entities.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PassBook implements IPassBook {
    private final HashMap<Customer, List<Loan>> passBook;


    public PassBook() {
        this.passBook = new HashMap<>();
    }


    @Override
    public void updateAccount(Customer customer, Bank bank, Account account) {

        Loan loan = getLoan(bank, customer);

        loan.addAccount(account);

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
