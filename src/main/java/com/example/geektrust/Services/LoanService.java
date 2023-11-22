package com.example.geektrust.Services;

import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.Entities.Installment;
import com.example.geektrust.Entities.Loan;
import com.example.geektrust.DTO.LoanDetails;
import com.example.geektrust.Repository.IPassBook;


public class LoanService implements ILoanService{
    private final IPassBook records;

    public LoanService(IPassBook records) {
        this.records = records;
    }

    public void saveEntry(Bank bank, Customer customer, LoanDetails data){
        Double amountToPay = calculateTotalAmountToPay(data);

        Installment installment = calculateFinalEMI(amountToPay, data.getYears());
        Loan loan = new Loan(bank, customer, installment,amountToPay);
        records.saveCustomer(customer,loan);
    }
    Double calculateTotalAmountToPay(LoanDetails data){
        int percentage = 100;
        Double rateOfInterest = data.getInterestRate()/ percentage;
        Double interest = (data.getPrincipal() * data.getYears() * rateOfInterest);
        return data.getPrincipal() + interest;
    }

    Installment calculateFinalEMI(Double finalAmountToPay, Double years) {

        int monthsInAYear = 12;
        Integer totalEmi = (int) Math.ceil(years* monthsInAYear);
        Integer costPerEmi = (int) Math.ceil(finalAmountToPay/totalEmi);

        return new Installment(totalEmi,costPerEmi);

    }
}
