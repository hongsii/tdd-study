package dev.hongsii.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameConsoleTest {

    private BaseballGameConsole baseballGameConsole;

    @Before
    public void setUp() {
        Answer answer = new Answer(BaseballNumberTest.createBaseballNumber(1, 2, 3));
        baseballGameConsole = new BaseballGameConsole(answer);
    }

    @Test
    public void play() {
        GuessResult guessResult = baseballGameConsole.play("123");

        assertThat(guessResult.isGameOver()).isTrue();
    }
}