package com.example.geektrust.Commands;

import com.example.geektrust.DTO.LoanDetails;
import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.Services.ILoanService;

import java.util.List;

public class CreateLoanCommand implements ICommand {

    private final ILoanService service;
    private final int BANK_NAME_INDEX = 1;
    private final int CUSTOMER_NAME_INDEX = 2;
    private final int PRINCIPAL_INDEX = 3;
    private final int TENURE_INDEX = 4;
    private final int INTEREST_RATE_INDEX = 5;

    public CreateLoanCommand(ILoanService service) {
        this.service = service;
    }

    @Override
    public void execute(List<String> tokens) {
        Bank bank = new Bank(tokens.get(BANK_NAME_INDEX));
        Customer customer = new Customer(tokens.get(CUSTOMER_NAME_INDEX));
        Double principal = Double.valueOf(tokens.get(PRINCIPAL_INDEX));
        Double tenure = Double.valueOf(tokens.get(TENURE_INDEX));
        Double interestRate = Double.valueOf(tokens.get(INTEREST_RATE_INDEX));
        LoanDetails data = new LoanDetails(principal, tenure, interestRate);

        service.saveEntry(bank, customer, data);

    }
}
