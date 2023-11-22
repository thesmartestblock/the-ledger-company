package com.example.geektrust.Services;

import com.example.geektrust.Entities.Account;
import com.example.geektrust.DTO.LoanAccountDetails;
import com.example.geektrust.Entities.Bank;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.Entities.Loan;
import com.example.geektrust.Repository.IPassBook;


public class BalanceService implements IBalanceService{
    private final IPassBook records;

    public BalanceService(IPassBook record) {
        this.records = record;
    }
    public LoanAccountDetails getBalance(Bank bank, Customer customer, Integer emiCount) {

        Loan loan = records.getLoan(bank, customer);


        int emiCost = loan.getInstallmentCost();
        int amountPaid = calculateAmountPaid(emiCount, loan, emiCost);
        int emiRemains = calculateEmiRemains(loan, amountPaid, emiCost);

        return new LoanAccountDetails(
                bank.getBankName(),
                customer.getUserName(),
                amountPaid,
                emiRemains
        );
    }

    private int calculateAmountPaid(int emiCount, Loan loan, int emiCost) {
        if (!loan.isAccountBeforeInstallment(emiCount)) {
            return emiCount * emiCost;
        } else {
            int sum = loan.getLumpSumBeforeInstallment(emiCount).stream()
                    .mapToInt(Account::getAmount).sum();
            int amountPaid = emiCount * emiCost + sum;
            return (amountPaid > loan.getTotalAmountToPay())?loan.getTotalAmountToPay().intValue():amountPaid;
        }
    }

    private int calculateEmiRemains(Loan loan, int amountPaid, int emiCost) {
        int remainingAmount = (int)Math.max(0, loan.getTotalAmountToPay() - amountPaid);
        return (int) Math.ceil(remainingAmount / (double) emiCost);
    }



}
