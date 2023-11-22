package com.example.geektrust.Commands;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.DTO.LoanDetails;
import com.example.geektrust.Services.ILoanService;

import java.util.List;

public class CreateLoanCommand implements ICommand{

    private final ILoanService service;

    public CreateLoanCommand(ILoanService service) {
        this.service = service;
    }

    @Override
    public void execute(List<String> tokens) {
        int BANK_NAME_INDEX = 1;
        Bank bank = new Bank(tokens.get(BANK_NAME_INDEX));
        int CUSTOMER_NAME_INDEX = 2;
        Customer customer = new Customer(tokens.get(CUSTOMER_NAME_INDEX));
        int PRINCIPAL_INDEX = 3;
        Double principal = Double.valueOf(tokens.get(PRINCIPAL_INDEX));
        int TENURE_INDEX = 4;
        Double tenure = Double.valueOf(tokens.get(TENURE_INDEX));
        int INTEREST_RATE_INDEX = 5;
        Double interestRate = Double.valueOf(tokens.get(INTEREST_RATE_INDEX));
        LoanDetails data= new LoanDetails(principal,tenure,interestRate);

        service.saveEntry(bank, customer,data);

    }
}
