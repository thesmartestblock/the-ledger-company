package com.example.geektrust.Services;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.Entities.Account;

public interface IPaymentService {
    void addPayment(Bank bank, Customer customer, Account payment);
}
