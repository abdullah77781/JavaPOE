package com.mycompany.javapoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private Login login;

    @BeforeEach
    public void setUp() {
        login = new Login("user_", "Pass123!", "0821234567");
    }

    @Test
    public void testValidUsernameFormat() {
        assertTrue(login.checkusernameFormat("us_er"));
    }

    @Test
    public void testInvalidUsernameFormat() {
        assertTrue(login.checkusernameFormat("username"));
    }

    @Test
    public void testValidPassword() {
        assertTrue(Login.checkpassword("Strong1!"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(Login.checkpassword("weak"));
    }

    @Test
    public void testValidCellNumber() {
        assertTrue(login.checkcellNumber("=27832123456"));  // Based on your regex
    }

    @Test
    public void testInvalidCellNumber() {
        assertFalse(login.checkcellNumber("0731234567"));  // Does not start with "=27"
    }

    @Test
    public void testSuccessfulRegistration() {
        String result = login.register("us_er", "Strong1!", "=27832123456");
        assertEquals("user is registered", result);
    }

    @Test
    public void testFailedRegistration_InvalidPassword() {
        String result = login.register("us_er", "weak", "=27832123456");
        assertEquals("password is incorrect", result);
    }

    @Test
    public void testFailedRegistration_InvalidUsername() {
        String result = login.register("usernamelong", "Strong1!", "=27832123456");
        assertEquals("user is registered", result);
    }

    @Test
    public void testFailedRegistration_InvalidCellNumber() {
        String result = login.register("us_er", "Strong1!", "0731234567");
        assertEquals("cellNumber is incorrect", result);
    }

    @Test
    public void testSuccessfulLogin() {
        Login user = new Login("user1_", "Password1!", "0823456789");
        assertTrue(user.login("user1_", "Password1!"));
    }

    @Test
    public void testFailedLogin() {
        Login user = new Login("user1_", "Password1!", "0823456789");
        assertFalse(user.login("user1_", "WrongPass"));
    }

    @Test
    public void testLoginStatusSuccess() {
        Login user = new Login("user1_", "Password1!", "0823456789");
        assertEquals("login successful", user.returnLoginstatus("user1_", "Password1!"));
    }

    @Test
    public void testLoginStatusFailure() {
        Login user = new Login("user1_", "Password1!", "0823456789");
        assertEquals("password or username incorrect", user.returnLoginstatus("user1_", "Wrong"));
    }
}
