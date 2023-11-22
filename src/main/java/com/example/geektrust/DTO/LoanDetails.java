package com.example.geektrust.DTO;

import java.util.Objects;

public class LoanDetails {
    private final Double principal;
    private final Double years;
    private final Double interestRate;

    public LoanDetails(Double principal, Double years, Double interestRate) {
        this.principal = principal;
        this.years = years;
        this.interestRate = interestRate;
    }

    public Double getPrincipal() {
        return principal;
    }

    public Double getYears() {
        return years;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    @Override
    public boolean equals(Object o) {
        return o == this || (o instanceof LoanDetails &&
                Objects.equals(principal, ((LoanDetails) o).principal) &&
                Objects.equals(years, ((LoanDetails) o).years) &&
                Objects.equals(interestRate, ((LoanDetails) o).interestRate));
    }

    @Override
    public int hashCode() {
        return Objects.hash(principal, years, interestRate);
    }

}
