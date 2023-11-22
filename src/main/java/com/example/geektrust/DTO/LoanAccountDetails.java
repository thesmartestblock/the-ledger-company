package com.example.geektrust.DTO;

public class LoanAccountDetails {
    private String bankname;
    private String customerName;
    private Integer paidAmount;
    private Integer pendingAmount;

    public LoanAccountDetails(String bankName, String customerName, Integer amountPaid, Integer pendingAmount) {
        this.bankname = bankName;
        this.customerName = customerName;
        this.paidAmount = amountPaid;
        this.pendingAmount = pendingAmount;
    }


    @Override
    public String toString() {
        return bankname + " " + customerName + " " + paidAmount + " " + pendingAmount;
    }
}
