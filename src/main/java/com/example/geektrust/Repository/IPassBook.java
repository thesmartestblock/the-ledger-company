package com.example.geektrust.Repository;


import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.Entities.Loan;
import com.example.geektrust.Entities.Account;

public interface IPassBook {

    void saveCustomer(Customer customer, Loan loan);

    Loan getLoan(Bank bank, Customer customer);

    void updateAccount(Customer customer, Bank bank, Account account);

}
