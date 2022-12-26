package org.example.javatests.util;

import org.example.javatests.payments.PaymentGateway;
import org.example.javatests.payments.PaymentProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzUtilTest {
    private FizzBuzzUtil fizzbuzz;

    @BeforeEach
    public void setup(){
        fizzbuzz = new FizzBuzzUtil();
    }


    @Test
    void returnFizz() { Assertions.assertEquals("Fizz", fizzbuzz.fizzBuzz(3)); };

    @Test
    void returnBuzz() { Assertions.assertEquals("Buzz", fizzbuzz.fizzBuzz(5)); }

    @Test
    void returnFizzBuzz() { Assertions.assertEquals("FizzBuzz", fizzbuzz.fizzBuzz(15)); }

    @Test
    void returnNumber() {Assertions.assertEquals("2", fizzbuzz.fizzBuzz(2));}
}