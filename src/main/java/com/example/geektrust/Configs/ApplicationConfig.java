package com.example.geektrust.Configs;

import java.util.HashMap;
import java.util.List;

import com.example.geektrust.Commands.AddPaymentCommand;
import com.example.geektrust.Commands.CreateLoanCommand;
import com.example.geektrust.Commands.GetBalanceCommand;
import com.example.geektrust.Commands.ICommand;
import com.example.geektrust.Entities.Customer;
import com.example.geektrust.Entities.Loan;
import com.example.geektrust.Repository.*;
import com.example.geektrust.Services.*;

public class ApplicationConfig {

    private final IPassBook book = new PassBook();

    private final ILoanService loanService = new LoanService(book);
    private final IBalanceService balanceService = new BalanceService(book);
    private final IPaymentService paymentService = new PaymentService(book);

    private final ICommand createLoan = new CreateLoanCommand(loanService);
    private final ICommand getBalance = new GetBalanceCommand(balanceService);
    private final ICommand registerPayment = new AddPaymentCommand(paymentService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker() {
        commandInvoker.registerCommand("LOAN", createLoan);
        commandInvoker.registerCommand("BALANCE", getBalance);
        commandInvoker.registerCommand("PAYMENT", registerPayment);
        return commandInvoker;
    }

}
