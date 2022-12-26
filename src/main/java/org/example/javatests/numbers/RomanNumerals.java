package org.example.javatests.numbers;

import java.util.Arrays;
import java.util.List;

public class RomanNumerals {
    private final static String[] ROMAN_NUMERAL = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    private final static int[] NUMBERS = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    public static String arabicToRoman(int n){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < NUMBERS.length; i++) {
            while(n>=NUMBERS[i]){
                result.append(ROMAN_NUMERAL[i]);
                n-=NUMBERS[i];
            }
        }
        return result.toString();
    }
}
