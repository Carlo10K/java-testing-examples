package org.example.javatests.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsTest {

    @Test
    @DisplayName("1")
    void returnI() {
        Assertions.assertEquals("I",RomanNumerals.arabicToRoman(1));
    }

    @Test
    @DisplayName("2")
    void returnII() {
        Assertions.assertEquals("II",RomanNumerals.arabicToRoman(2));
    }

    @Test
    @DisplayName("3")
    void returnIII() {
        Assertions.assertEquals("III",RomanNumerals.arabicToRoman(3));
    }

    @Test
    @DisplayName("5")
    void returnV() {
        Assertions.assertEquals("V",RomanNumerals.arabicToRoman(5));
    }

    @Test
    @DisplayName("6")
    void returnVI() {
        Assertions.assertEquals("VI",RomanNumerals.arabicToRoman(6));
    }

    @Test
    @DisplayName("7")
    void returnVII(){
        Assertions.assertEquals("VII", RomanNumerals.arabicToRoman(7));
    }

    @Test
    @DisplayName("10")
    void returnX() {
        Assertions.assertEquals("X", RomanNumerals.arabicToRoman(10));
    }

    @Test
    @DisplayName("11")
    void returnXI() {
        Assertions.assertEquals("XI", RomanNumerals.arabicToRoman(11));
    }

    @Test
    @DisplayName("15")
    void returnXV() {
        Assertions.assertEquals("XV", RomanNumerals.arabicToRoman(15));
    }

    @Test
    @DisplayName("16")
    void returnXVI() {
        Assertions.assertEquals("XVI", RomanNumerals.arabicToRoman(16));
    }

    @Test
    @DisplayName("50")
    void returnL() {
        Assertions.assertEquals("L", RomanNumerals.arabicToRoman(50));
    }

    @Test
    @DisplayName("51")
    void returnLI() {
        Assertions.assertEquals("LI", RomanNumerals.arabicToRoman(51));
    }

    @Test
    @DisplayName("55")
    void returnLV() {
        Assertions.assertEquals("LV", RomanNumerals.arabicToRoman(55));
    }

    @Test
    @DisplayName("56")
    void returnLVI() {
        Assertions.assertEquals("LVI", RomanNumerals.arabicToRoman(56));
    }

    @Test
    @DisplayName("60")
    void returnLX() {
        Assertions.assertEquals("LX", RomanNumerals.arabicToRoman(60));
    }

    @Test
    @DisplayName("70")
    void returnLXX() {
        Assertions.assertEquals("LXX", RomanNumerals.arabicToRoman(70));
    }

    @Test
    @DisplayName("80")
    void returnLXXX() {
        Assertions.assertEquals("LXXX", RomanNumerals.arabicToRoman(80));
    }

    @Test
    @DisplayName("81")
    void returnLXXXI() {
        Assertions.assertEquals("LXXXI", RomanNumerals.arabicToRoman(81));
    }

    @Test
    @DisplayName("85")
    void returnLXXXV() {
        Assertions.assertEquals("LXXXV", RomanNumerals.arabicToRoman(85));
    }

    @Test
    @DisplayName("86")
    void returnLXXXVI() {
        Assertions.assertEquals("LXXXVI", RomanNumerals.arabicToRoman(86));
    }

    @Test
    @DisplayName("126")
    void returnCXXVI() {
        Assertions.assertEquals("CXXVI", RomanNumerals.arabicToRoman(126));
    }

    @Test
    @DisplayName("2507")
    void returnMMDVII() {
        Assertions.assertEquals("MMDVII", RomanNumerals.arabicToRoman(2507));
    }

    @Test
    @DisplayName("4")
    void returnIV() {
        Assertions.assertEquals("IV", RomanNumerals.arabicToRoman(4));
    }

    @Test
    @DisplayName("9")
    void returnIX() {
        Assertions.assertEquals("IX", RomanNumerals.arabicToRoman(9));
    }

    @Test
    @DisplayName("14")
    void returnXIV() {
        Assertions.assertEquals("XIV", RomanNumerals.arabicToRoman(14));
    }

    @Test
    @DisplayName("19")
    void returnXIX() {
        Assertions.assertEquals("XIX", RomanNumerals.arabicToRoman(19));
    }

    @Test
    @DisplayName("24")
    void returnXXIX() {
        Assertions.assertEquals("XXIV", RomanNumerals.arabicToRoman(24));
    }

    @Test
    @DisplayName("40")
    void returnXL() {
        Assertions.assertEquals("XL", RomanNumerals.arabicToRoman(40));
    }

    @Test
    @DisplayName("49")
    void returnXLIX() {
        Assertions.assertEquals("XLIX", RomanNumerals.arabicToRoman(49));
    }

    @Test
    @DisplayName("90")
    void returnXC() {
        Assertions.assertEquals("XC", RomanNumerals.arabicToRoman(90));
    }

    @Test
    @DisplayName("99")
    void returnXCIX() {
        Assertions.assertEquals("XCIX", RomanNumerals.arabicToRoman(99));
    }

    @Test
    @DisplayName("400")
    void returnCD() {
        Assertions.assertEquals("CD", RomanNumerals.arabicToRoman(400));
    }

    @Test
    @DisplayName("900")
    void returnCM() {
        Assertions.assertEquals("CM", RomanNumerals.arabicToRoman(900));
    }
}