package com.example.geektrust.Entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class AccountManagerTest {

    private AccountManager accountManager;

    @BeforeEach
    void setUp() {
        accountManager = new AccountManager();
    }

    @Test
    void addLumpsum() {
        // Arrange
        Account account = new Account(1000, 1);

        // Act
        accountManager.addAccount(account);

        // Assert
        List<Account> accountPayments = accountManager.getLumpSumBeforeInstallment(2);
        assertEquals(1, accountPayments.size());
        assertEquals(account, accountPayments.get(0));
    }

    @Test
    void getLumpSumBeforeEmi() {
        // Arrange
        Account account1 = new Account(500, 2);
        Account account2 = new Account(800, 3);

        // Act
        accountManager.addAccount(account1);
        accountManager.addAccount(account2);

        // Assert
        List<Account> accountPayments = accountManager.getLumpSumBeforeInstallment(3);
        assertEquals(2, accountPayments.size());
        assertTrue(accountPayments.contains(account1));
        assertTrue(accountPayments.contains(account2));
    }

    @Test
    void isLumpsumBeforeEmi() {
        // Arrange
        Account account1 = new Account(500, 2);

        // Act
        accountManager.addAccount(account1);

        // Assert
        assertTrue(accountManager.isAccountBeforeInstallment(2));

    }
}
