package com.example.geektrust.Configs;

import com.example.geektrust.Commands.AddPaymentCommand;
import com.example.geektrust.Commands.CreateLoanCommand;
import com.example.geektrust.Commands.GetBalanceCommand;
import com.example.geektrust.Commands.ICommand;
import com.example.geektrust.Repository.*;
import com.example.geektrust.Services.*;

public class ApplicationConfig {

    private final ILoanAccountManager loanAccountManager = new LoanAccountManager();
    private final IPaymentManager paymentManager = new PaymentManager(loanAccountManager);

    private final IPassBook book = new PassBook(loanAccountManager, paymentManager);

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
