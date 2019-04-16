package dev.hongsii.model;

import org.junit.Test;

public class DigitTest {

    @Test(expected = IllegalArgumentException.class)
    public void createFailOutOfLowerRange() {
        createDigit(Digit.MIN - 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFailOutOfHigherRange() {
        createDigit(Digit.MAX + 1);
    }

    public static Digit createDigit(int digit) {
        return new Digit(digit);
    }
}
