package com.example.geektrust.Services;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.DTO.LoanAccountDetails;

public interface IBalanceService {
    LoanAccountDetails getBalance(Bank bank, Customer customer, Integer emiCount);
}
