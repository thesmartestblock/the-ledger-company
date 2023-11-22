package com.example.geektrust.DTO;

public class LoanAccountDetails {
    private final String bankName;
    private final String customerName;
    private final Integer paidAmount;
    private final Integer pendingAmount;

    public LoanAccountDetails(String bankName, String customerName, Integer amountPaid, Integer pendingAmount) {
        this.bankName = bankName;
        this.customerName = customerName;
        this.paidAmount = amountPaid;
        this.pendingAmount = pendingAmount;
    }


    @Override
    public String toString() {
        return bankName + " " + customerName + " " + paidAmount + " " + pendingAmount;
    }
}
