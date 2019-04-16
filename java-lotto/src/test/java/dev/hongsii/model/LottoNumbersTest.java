package dev.hongsii.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    private LottoNumbers lottoNumbers;

    @Before
    public void setUp() {
        lottoNumbers = createNumbers(LottoNumbers.NUMBER_SIZE);
    }

    @Test
    public void create() {
        assertThat(lottoNumbers).isNotNull();
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFailWhenNumberSizeIsLessThan() {
        createNumbers(LottoNumbers.NUMBER_SIZE - 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFailWhenNumberSizeIsGreaterThan() {
        createNumbers(LottoNumbers.NUMBER_SIZE + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFailIfIncludeDuplicatedNumber() {
        createNumbers(1, 1, 3, 4, 5, 6);
    }

    @Test
    public void hasNumberIfContains() {
        assertThat(lottoNumbers.hasNumber(LottoNumber.of(1))).isTrue();
    }

    @Test
    public void hasNumberIfNotContains() {
        assertThat(lottoNumbers.hasNumber(LottoNumber.of(7))).isFalse();
    }

    public static LottoNumbers createNumbers(int size) {
        return createNumbers(
                IntStream.rangeClosed(1, size)
                        .boxed()
                        .collect(Collectors.toList())
        );
    }

    public static LottoNumbers createNumbers(Integer... numbers) {
        return createNumbers(
                Arrays.stream(numbers)
                        .collect(Collectors.toList())
        );
    }

    public static LottoNumbers createNumbers(List<Integer> numbers) {
        return new LottoNumbers(
                numbers.stream()
                        .map(LottoNumberTest::createLottoNumber)
                        .collect(Collectors.toList())
        );
    }
}