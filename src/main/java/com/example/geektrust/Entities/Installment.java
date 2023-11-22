package com.example.geektrust.Entities;



public class Installment {

    private final Integer installmentNumber;
    private final Integer installmentAmount;

    public Installment(Integer installmentNumber, Integer installmentAmount) {
        this.installmentNumber = installmentNumber;
        this.installmentAmount = installmentAmount;
    }

    public Integer getInstallmentNumber() {
        return installmentNumber;
    }


    public Integer getInstallmentAmount() {
        return installmentAmount;
    }

}
