package com.example.geektrust.Commands;

import com.example.geektrust.DTO.LoanAccountDetails;
import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.Services.IBalanceService;

import java.util.List;

public class GetBalanceCommand implements ICommand {

    private final IBalanceService service;
    private final int BANK_NAME_INDEX = 1;
    private final int CUSTOMER_NAME_INDEX = 2;
    private final int EMI_COUNT_INDEX = 3;

    public GetBalanceCommand(IBalanceService service) {
        this.service = service;
    }

    @Override
    public void execute(List<String> tokens) {
        Bank bank = new Bank(tokens.get(BANK_NAME_INDEX));
        Customer customer = new Customer(tokens.get(CUSTOMER_NAME_INDEX));
        int emiCount = Integer.parseInt(tokens.get(EMI_COUNT_INDEX));
        LoanAccountDetails balance = service.getBalance(bank, customer, emiCount);
        System.out.println(balance);
    }
}
