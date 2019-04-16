package dev.hongsii.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerTest {

    @Test
    public void guess() {
        Answer answer = new Answer(BaseballNumberTest.createBaseballNumber(1, 2, 3));

        GuessResult guessResult = answer.guess(BaseballNumberTest.createBaseballNumber(1, 2, 3));

        assertThat(guessResult.getGuessCount()).isEqualTo(1);
        assertThat(guessResult.getMatchResult().getResultTypes()).hasSize(3);
    }
}