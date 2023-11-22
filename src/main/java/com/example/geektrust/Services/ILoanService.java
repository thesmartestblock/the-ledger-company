package com.example.geektrust.Services;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.DTO.LoanDetails;

public interface ILoanService {
    void saveEntry(Bank bank, Customer customer, LoanDetails data);
}
