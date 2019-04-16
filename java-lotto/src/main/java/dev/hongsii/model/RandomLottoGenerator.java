package dev.hongsii.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomLottoGenerator {

    private Random random;

    public RandomLottoGenerator() {
        this.random = new Random();
    }

    public Lotto generate() {
        List<LottoNumber> numbers = pickUniqueNumbers();
        LottoNumber bonusNumber = pickUniqueNumber(numbers);
        return new Lotto(new LottoNumbers(numbers), bonusNumber);
    }

    private List<LottoNumber> pickUniqueNumbers() {
        List<LottoNumber> numbers = new ArrayList<>();
        while (numbers.size() < LottoNumbers.NUMBER_SIZE) {
            numbers.add(pickUniqueNumber(numbers));
        }
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private LottoNumber pickUniqueNumber(List<LottoNumber> numbers) {
        LottoNumber number;
        do {
            number = pickRandomNumber();
        } while (numbers.contains(number));
        return number;
    }

    private LottoNumber pickRandomNumber() {
        return LottoNumber.of(random.nextInt(LottoNumber.MAX) + 1);
    }
}
