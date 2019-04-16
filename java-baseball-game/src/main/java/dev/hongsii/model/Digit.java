package dev.hongsii.model;

import java.util.Objects;

public class Digit {

    public static final int MIN = 1;
    public static final int MAX = 9;

    private int digit;

    public Digit(int digit) {
        if (isOutOfRange(digit)) {
            throw new IllegalArgumentException(String.format("%d ~ %d 사이의 숫자만 가능합니다.", MIN, MAX));
        }

        this.digit = digit;
    }

    private boolean isOutOfRange(int digit) {
        return digit < MIN || digit > MAX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digit digit1 = (Digit) o;
        return digit == digit1.digit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(digit);
    }

    @Override
    public String toString() {
        return Integer.toString(digit);
    }
}