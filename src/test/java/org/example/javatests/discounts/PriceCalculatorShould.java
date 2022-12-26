package org.example.javatests.discounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorShould {
    @Test
    @DisplayName("return zero when not are prices")
    void zeroWhenNotPrices() {
        PriceCalculator calculator = new PriceCalculator();

        Assertions.assertEquals(0.0, calculator.getTotal());
    }

    @Test
    @DisplayName("return the sum of the prices")
    void sumOfPrices() {
        PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice(10.5);
        calculator.addPrice(15.2);

        Assertions.assertEquals(25.7, calculator.getTotal());
    }

    @Test
    @DisplayName("apply a discount to the price")
    void applyDiscount() {
        PriceCalculator calculator = new PriceCalculator();

        calculator.addPrice(100);
        calculator.addPrice(50);
        calculator.addPrice(50);

        calculator.setDiscount(25);

        Assertions.assertEquals(150, calculator.getTotal());

    }
}