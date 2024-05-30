package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import domain.Account;

class AccountTest {

    @Test
    void testGetId() {
        Account account = new Account("user123", "password");
        assertEquals("user123", account.getId());
    }

    @Test
    void testGetPassword() {
        Account account = new Account("user123", "password");
        assertEquals("password", account.getPassword());
    }

    @Test
    void testToString() {
        Account account = new Account("user123", "password");
        assertEquals("user123", account.toString());
    }
}