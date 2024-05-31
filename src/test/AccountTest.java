
package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import domain.Account;

class AccountTest {

    @Test
    void testAccount() {
        Account account = new Account("user123", "password");
        assertEquals("user123", account.getId());
        assertEquals("password", account.getPassword());
        assertEquals("user123", account.toString());
    }
}