package com.example.geektrust.Repository;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.Entities.Loan;

public interface ILoanAccountManager {
    void saveCustomer(Customer customer, Loan loan);

    Loan getLoan(Bank bank, Customer customer);
}
