package com.example.geektrust.Commands;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.DTO.LoanAccountDetails;
import com.example.geektrust.Services.IBalanceService;

import java.util.List;

public class GetBalanceCommand implements ICommand{

    private final IBalanceService service;

    public GetBalanceCommand(IBalanceService service) {
        this.service = service;
    }

    @Override
    public void execute(List<String> tokens) {
        int BANK_NAME_INDEX = 1;
        Bank bank = new Bank(tokens.get(BANK_NAME_INDEX));
        int CUSTOMER_NAME_INDEX = 2;
        Customer customer = new Customer(tokens.get(CUSTOMER_NAME_INDEX));
        int EMI_COUNT_INDEX = 3;
        int emiCount = Integer.parseInt(tokens.get(EMI_COUNT_INDEX));
        LoanAccountDetails balance = service.getBalance(bank, customer, emiCount);
        System.out.println(balance);
    }
}
