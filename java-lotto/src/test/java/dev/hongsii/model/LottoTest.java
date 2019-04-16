package dev.hongsii.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    public static final List<Integer> DEFAULT_NUMBERS = asList(1, 2, 3, 4 ,5 ,6);
    public static final int DEFAULT_BONUS_NUMBER = 7;

    private Lotto lotto;

    @Before
    public void setUp() {
        lotto = createLotto();
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFailIfHasBonusNumberInNumbers() {
        createLotto(DEFAULT_NUMBERS, DEFAULT_NUMBERS.get(0));
    }

    @Test
    public void match() {
        Lotto other = createLotto();

        assertThat(lotto.match(other)).isEqualTo(6);
    }

    @Test
    public void matchBonus() {
        Lotto other = createLotto();

        assertThat(lotto.matchBonus(other)).isTrue();
    }

    @Test
    public void matchBonusWhenDifferentBonusNumber() {
        Lotto other = createLotto(DEFAULT_NUMBERS, DEFAULT_BONUS_NUMBER + 1);

        assertThat(lotto.matchBonus(other)).isFalse();
    }

    public static Lotto createLotto() {
        return createLotto(DEFAULT_NUMBERS, DEFAULT_BONUS_NUMBER);
    }

    public static Lotto createLotto(List<Integer> numbers, Integer bonusNumber) {
        return new Lotto(
                LottoNumbersTest.createNumbers(numbers),
                LottoNumberTest.createLottoNumber(bonusNumber)
        );
    }
}
