package org.example.javatests.util;

public class FizzBuzzUtil {
    public String fizzBuzz (int n) {
        String result = "";

        if (n % 3 == 0) {
            result += "Fizz";
        }

        if (n % 5 == 0) {
            result += "Buzz";
        }

        if (result.isEmpty()) {
            return String.valueOf(n);
        } else {
            return result;
        }
    }
}

