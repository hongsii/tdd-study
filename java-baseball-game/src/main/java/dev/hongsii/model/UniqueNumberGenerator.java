package dev.hongsii.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UniqueNumberGenerator {

    private List<Digit> numbers;

    public UniqueNumberGenerator() {
        this.numbers = createNumbers();
    }

    private List<Digit> createNumbers() {
        return IntStream.rangeClosed(Digit.MIN, Digit.MAX)
                .mapToObj(Digit::new)
                .collect(Collectors.toList());
    }

    public BaseballNumber generate(int numberCount) {
        return new BaseballNumber(pickRandomNumbers(numberCount));
    }

    private List<Digit> pickRandomNumbers(int numberCount) {
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(numberCount)
                .collect(Collectors.toList());
    }
}
