package dev.hongsii.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class WinningAnalyzerTest {

    private WinningAnalyzer winningAnalyzer;

    @Before
    public void setUp() {
        winningAnalyzer = new WinningAnalyzer(asList(
                WinningResult.FIRST,
                WinningResult.SECOND,
                WinningResult.SECOND
        ));
    }

    @Test
    public void analyzeByWinningResult() {
        Map<WinningResult, Integer> statistics =  winningAnalyzer.analyzeByWinningResult();

        assertThat(statistics).contains(
                entry(WinningResult.FIRST, 1),
                entry(WinningResult.SECOND, 2),
                entry(WinningResult.THIRD, 0),
                entry(WinningResult.FOURTH, 0),
                entry(WinningResult.FIFTH, 0),
                entry(WinningResult.NOT_MATCH, 0)
        );
    }

    @Test
    public void calculateTotalPrice() {
        int totalPrice = winningAnalyzer.calculateTotalPrice();

        int expected = WinningResult.FIRST.getPrice() + WinningResult.SECOND.getPrice() * 2;
        assertThat(totalPrice).isEqualTo(expected);
    }
}