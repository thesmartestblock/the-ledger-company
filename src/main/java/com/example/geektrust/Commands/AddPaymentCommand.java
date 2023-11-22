package com.example.geektrust.Commands;

import com.example.geektrust.Entities.Account;
import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.Services.IPaymentService;

import java.util.List;

public class AddPaymentCommand implements ICommand {

    private final IPaymentService service;

    private final int BANK_NAME_INDEX = 1;
    private final int CUSTOMER_NAME_INDEX = 2;
    private final int PAYMENT_AMOUNT_INDEX = 3;
    private final int INSTALLMENT_NUMBER_INDEX = 4;

    public AddPaymentCommand(IPaymentService service) {
        this.service = service;
    }

    @Override
    public void execute(List<String> tokens) {
        Bank bank = new Bank(tokens.get(BANK_NAME_INDEX));
        Customer customer = new Customer(tokens.get(CUSTOMER_NAME_INDEX));
        Integer amountPaid = Integer.valueOf(tokens.get(PAYMENT_AMOUNT_INDEX));
        Integer emiNumber = Integer.valueOf(tokens.get(INSTALLMENT_NUMBER_INDEX));
        Account payment = new Account(amountPaid, emiNumber);
        service.addPayment(bank, customer, payment);
    }
}
