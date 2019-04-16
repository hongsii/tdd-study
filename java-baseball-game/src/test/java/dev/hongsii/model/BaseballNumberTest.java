package dev.hongsii.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static dev.hongsii.model.ResultType.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseballNumberTest {

    private BaseballNumber baseballNumber;

    @Before
    public void setUp() {
        baseballNumber = createBaseballNumber(1, 2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFailWhenContainsDuplicatedNumber() {
        createBaseballNumber(1, 1, 2);
    }

    @Test
    public void matchOnlyOneResult() {
        assertMatching(createBaseballNumber(1, 2, 3), STRIKE, STRIKE, STRIKE);
        assertMatching(createBaseballNumber(3, 1, 2), BALL, BALL, BALL);
        assertMatching(createBaseballNumber(4, 5, 6), OUT, OUT, OUT);
    }

    @Test
    public void matchTwoResult() {
        assertMatching(createBaseballNumber(1, 3, 2), STRIKE, BALL, BALL);
        assertMatching(createBaseballNumber(1, 2, 4), STRIKE, STRIKE, OUT);
        assertMatching(createBaseballNumber(4, 3, 2), OUT, BALL, BALL);
    }

    @Test
    public void matchByEachCase() {
        assertMatching(createBaseballNumber(3, 2, 9), STRIKE, BALL, OUT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void matchFailWhenIsDifferentNumberSize() {
        baseballNumber.match(createBaseballNumber(1, 2, 3, 4));
    }

    @Test
    public void fromComma() {
        assertThat(BaseballNumber.from("123")).isEqualTo(baseballNumber);
    }

    private void assertMatching(BaseballNumber other, ResultType... expected) {
        MatchResult matchResult = this.baseballNumber.match(other);
        assertThat(matchResult.getResultTypes()).containsExactlyInAnyOrder(expected);
    }

    public static BaseballNumber createBaseballNumber(Integer... numbers) {
        return new BaseballNumber(
                Arrays.stream(numbers)
                        .map(DigitTest::createDigit)
                        .collect(Collectors.toList())
        );
    }
}
