package dev.hongsii.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN = 1;
    public static final int MAX = 45;
    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();

    private int number;

    private LottoNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(String.format("%d ~ %d 만 가능합니다.", MIN, MAX));
        }

        this.number = number;
    }

    public static LottoNumber of(int number) {
        if (CACHE.containsKey(number)) {
            return CACHE.get(number);
        }

        LottoNumber lottoNumber = new LottoNumber(number);
        CACHE.put(number, lottoNumber);
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(number, other.number);
    }
}
