package dev.hongsii.model;

import org.junit.Test;

import static dev.hongsii.model.LottoNumber.MAX;
import static dev.hongsii.model.LottoNumber.MIN;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    public void create() {
        assertThat(createLottoNumber(1) == createLottoNumber(1)).isTrue();
        assertThat(createLottoNumber(MIN) == createLottoNumber(MIN)).isTrue();
        assertThat(createLottoNumber(MAX) == createLottoNumber(MAX)).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFailWhenNumberIsLessThanMin() {
        createLottoNumber(MIN - 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFailWhenNumberIsGreaterThanMax() {
        createLottoNumber(MAX + 1);
    }

    public static LottoNumber createLottoNumber(int i) {
        return LottoNumber.of(i);
    }
}