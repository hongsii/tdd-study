package dev.hongsii.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int NUMBER_SIZE = 6;

    private List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(String.format("로또는 %d개의 숫자가 필요합니다.", NUMBER_SIZE));
        }
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException("숫자는 중복될 수 없습니다.");
        }

        this.numbers = numbers;
    }

    private boolean hasDuplicatedNumber(List<LottoNumber> numbers) {
        long distinctNumberCount = numbers.stream()
                .distinct()
                .count();
        return distinctNumberCount != NUMBER_SIZE;
    }

    public boolean hasNumber(LottoNumber number) {
        return numbers.contains(number);
    }

    public int count(LottoNumbers other) {
        return (int) numbers.stream()
                .filter(other::hasNumber)
                .count();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
