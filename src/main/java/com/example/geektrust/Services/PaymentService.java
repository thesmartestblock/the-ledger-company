package com.example.geektrust.Services;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.Entities.Account;
import com.example.geektrust.Repository.IPassBook;

public class PaymentService implements IPaymentService {
    private final IPassBook passBook;

    public PaymentService(IPassBook passBook) {
        this.passBook = passBook;
    }

    public void addPayment(Bank bank, Customer customer, Account payment) {
        passBook.updateAccount(customer,bank,payment);
    }

}
