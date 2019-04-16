package dev.hongsii.model;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class MatchResultTest {

    @Test
    public void record() {
        MatchResult matchResult = MatchResult.init();

        matchResult.record(true, true);

        assertThat(matchResult.getResultTypes()).hasSize(1).containsOnly(ResultType.STRIKE);
    }

    @Test
    public void isAllStrike() {
        MatchResult matchResult = MatchResult.of(asList(ResultType.STRIKE, ResultType.STRIKE, ResultType.STRIKE));

        assertThat(matchResult.isAllStrike()).isTrue();
    }

    @Test
    public void isNotOfStrike() {
        MatchResult matchResult = MatchResult.of(asList(ResultType.BALL, ResultType.STRIKE, ResultType.STRIKE));

        assertThat(matchResult.isAllStrike()).isFalse();
    }
}