package dev.hongsii.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {

    @Test
    public void winMatchingSix() {
        assertWinningResult(6, true, WinningResult.FIRST);
        assertWinningResult(6, false, WinningResult.FIRST);
    }

    @Test
    public void winMatchingFive() {
        assertWinningResult(5, true, WinningResult.SECOND);
        assertWinningResult(5, false, WinningResult.THIRD);
    }

    @Test
    public void winMatchingFour() {
        assertWinningResult(4, true, WinningResult.FOURTH);
        assertWinningResult(4, false, WinningResult.FOURTH);
    }

    @Test
    public void winMatchingThree() {
        assertWinningResult(3, true, WinningResult.FIFTH);
        assertWinningResult(3, false, WinningResult.FIFTH);
    }

    @Test
    public void winNotMatch() {
        assertWinningResult(2, true, WinningResult.NOT_MATCH);
        assertWinningResult(2, false, WinningResult.NOT_MATCH);
        assertWinningResult(1, true, WinningResult.NOT_MATCH);
        assertWinningResult(1, false, WinningResult.NOT_MATCH);
    }

    private void assertWinningResult(int matchCount, boolean matchBonus, WinningResult first) {
        WinningResult winningResult = WinningResult.of(new MatchResult(matchCount, matchBonus));

        assertThat(winningResult).isEqualTo(first);
    }

}