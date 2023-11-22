package com.example.geektrust.Commands;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.Entities.Account;
import com.example.geektrust.Services.IPaymentService;


import java.util.List;

public class AddPaymentCommand implements ICommand{

    private final IPaymentService service;


    public AddPaymentCommand(IPaymentService service) {
        this.service = service;
    }

    @Override
    public void execute(List<String> tokens) {
        int BANK_NAME_INDEX = 1;
        Bank bank = new Bank(tokens.get(BANK_NAME_INDEX));
        int CUSTOMER_NAME_INDEX = 2;
        Customer customer = new Customer(tokens.get(CUSTOMER_NAME_INDEX));
        int PAYMENT_AMOUNT_INDEX = 3;
        Integer amountPaid = Integer.valueOf(tokens.get(PAYMENT_AMOUNT_INDEX));
        int INSTALLMENT_NUMBER_INDEX = 4;
        Integer emiNumber = Integer.valueOf(tokens.get(INSTALLMENT_NUMBER_INDEX));
        Account payment = new Account(amountPaid,emiNumber);
        service.addPayment(bank, customer,payment);
    }
}
