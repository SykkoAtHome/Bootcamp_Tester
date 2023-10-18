package com.kodilla.parametrized_tests.homework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTestSuite {

    private UserValidator userValidator = new UserValidator();


    // Username Test
    @ParameterizedTest
    @ValueSource(strings = { "aaa_bbB", "aA.b1", "aa-bb", "ABcd", "ab1", "1-1", "._.", "---" })
    public void usernameTestWithCharAllowed(String username) {
        assertTrue(userValidator.validateUsername(username));
    }

    @ParameterizedTest
    @ValueSource(strings = { "aa", "..", "12", "-", "_" })
    public void usernameShouldReturnFalseWhenLessThan3Chars(String username) {
        assertFalse(userValidator.validateUsername(username));
    }
    @ParameterizedTest
    @ValueSource(strings = { "!", "#", "$", "%", "^", "&", "*", "(", ")", "=", "+", "/", "?", ">", "<", "|", ";", ":", ",", "`", " " })
    public void usernameShouldReturnFalseWhenSpecialChars(String invChar) {
        assertFalse(userValidator.validateUsername(invChar+"username"+invChar));
    }
    @ParameterizedTest
    @ValueSource(strings = { "jkhfe.kfhfhefh_ehfihfihg-reihgshfseuhg858565675uhfewsuihgswouihgsuhgsihgoripu", "eehfweihfwefhewhfeuihfewihfewihfw.iuhgiuwehfuiwehgiuwehf-iuwegfiufghfiwugfiuw_egfiwuegiwuegfwiuegfuiwgfiueghfieugfiweug" })
    public void usernameShouldReturnTrueWhenLongValues(String username) {
        assertTrue(userValidator.validateUsername(username));
    }
    @ParameterizedTest
    @NullAndEmptySource
    public void usernameTestValidateUsernameWhenNullOrEmpty(String username) {
        assertFalse(userValidator.validateUsername(username));
    }

    // E-mail test

    @ParameterizedTest
    @ValueSource(strings = { "useR@example.com", "john.doe@MY-website.CO.uk", "J.smith@sub.domain.example.ORG", "12345@numbers123.com", "username@domain.looong", "test-email@email.c", "hello_my-name-is-slim-shady@very.long.and.complicated.email.adre.ss", "u@email.c" })
    public void emailShouldReturnTrueWhenValid(String email) {
        assertTrue(userValidator.validateEmail(email));
    }

    @ParameterizedTest
    @ValueSource(strings = { "user@example.", "user@example", "@example.com", "@example", "userexample.com", "example", "user@example.example", "user@user@example.com", "user@@example.com", "user@example..com" })
    public void emailShouldReturnFalseWhenInvalidFormat(String email) {
        assertFalse(userValidator.validateEmail(email));
    }
    @ParameterizedTest
    @ValueSource(strings = { "!", "#", "$", "%", "^", "&", "*", "(", ")", "=", "+", "/", "?", ">", "<", "|", ";", ":", ",", "`", " " })
    public void emailShouldReturnFalseWhenUsernameInvalidChar(String invChar) {
        assertFalse(userValidator.validateEmail(invChar+"user"+invChar+"@example.com"));
    }
    @ParameterizedTest
    @ValueSource(strings = { "!", "#", "$", "%", "^", "&", "*", "(", ")", "=", "+", "/", "?", ">", "<", "|", ";", ":", ",", "`", " " })
    public void emailShouldReturnFalseWhenDomainInvalidChar(String invChar) {
        assertFalse(userValidator.validateEmail("username@"+invChar+"example"+invChar+".com"));
        System.out.println("username@"+invChar+"example"+invChar+".com");
    }
    @ParameterizedTest
    @NullAndEmptySource
    public void emailShouldReturnFalseWhenNullOrEmpty(String email) {
        assertFalse(userValidator.validateEmail(email));
    }
}