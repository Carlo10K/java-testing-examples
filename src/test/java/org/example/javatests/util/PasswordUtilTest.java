package org.example.javatests.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.javatests.util.PasswordUtil.SecurityLevel.*;

class PasswordUtilTest {
    @Test
    void weakWhenHasLessThan8Letters() {
        Assertions.assertEquals(WEAK, PasswordUtil.assessPassword("123!!12"));
    }

    @Test
    void weakWhenHasOnlyLetters() {
        Assertions.assertEquals(WEAK, PasswordUtil.assessPassword("aadfaafdfadfdfa"));
    }

    @Test
    void mediumWhenHasLettersAndNumbers() {
        Assertions.assertEquals(MEDIUM, PasswordUtil.assessPassword("abcd123222245"));
    }

    @Test
    void strongWhenHasLettersNumbersAndSymbols() {
        Assertions.assertEquals(STRONG, PasswordUtil.assessPassword("abcd12345!"));
    }


}

