package org.example.javatests.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilLeapYearShould {

    /*
    All years divisible by 400 are leap years (1600, 2000, 2400)
    All years divisible by 100 but not by 400 are NOT leap years (1700, 1880, 1900)
    All years divisible by 4 byt not by 100 are leap years (1996, 2004, 2008)
    All years not divisible by 4 are NOT leap years (2017, 2018, 2019)
     */

    @Test
    @DisplayName("return ture when the number is divisible by 400")
    void returnTrueWhenYearIsDivBy400() {
        Assertions.assertTrue(DateUtil.isLeapYear(1600));
        Assertions.assertTrue(DateUtil.isLeapYear(2000));
        Assertions.assertTrue(DateUtil.isLeapYear(2400));

    }

    @Test
    @DisplayName("return false when the number is divisible by 100 but not by 400")
    void returnFalseWhenDivBy100ButNotBy400() {
        Assertions.assertFalse(DateUtil.isLeapYear(1700));
        Assertions.assertFalse(DateUtil.isLeapYear(1800));
        Assertions.assertFalse(DateUtil.isLeapYear(1900));
    }

    @Test
    @DisplayName("return false when the number is divisible by 4 but not by 100")
    void returnTrueWhenDivBy4ButNotBy100() {
        Assertions.assertTrue(DateUtil.isLeapYear(1996));
        Assertions.assertTrue(DateUtil.isLeapYear(2004));
        Assertions.assertTrue(DateUtil.isLeapYear(2008));
    }

    @Test
    @DisplayName("return false when the number is not divisible by 4")
    void returnFalseWhenDivNotBy4() {
        Assertions.assertFalse(DateUtil.isLeapYear(2017));
        Assertions.assertFalse(DateUtil.isLeapYear(2018));
        Assertions.assertFalse(DateUtil.isLeapYear(2019));
    }
}