package dev.hongsii.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTypeTest {

    @Test
    public void strike() {
        assertThat(ResultType.of(true, true)).isEqualTo(ResultType.STRIKE);
    }

    @Test
    public void ball() {
        assertThat(ResultType.of(true, false)).isEqualTo(ResultType.BALL);
    }

    @Test
    public void out() {
        assertThat(ResultType.of(false, false)).isEqualTo(ResultType.OUT);
    }
}