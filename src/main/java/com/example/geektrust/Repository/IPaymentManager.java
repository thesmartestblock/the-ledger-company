package com.example.geektrust.Repository;

import com.example.geektrust.Entities.Account;
import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;

public interface IPaymentManager {
    void updateAccount(Customer customer, Bank bank, Account account);
}
