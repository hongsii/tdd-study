package dev.hongsii.model;

import java.util.Arrays;

public enum WinningResult {

    FIRST(6, false, 1_000_000),
    SECOND(5, true, 500_000),
    THIRD(5, false, 200_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NOT_MATCH(0, false, 0);

    private int matchCount;
    private boolean matchBonus;
    private int price;

    WinningResult(int matchCount, boolean matchBonus, int price) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.price = price;
    }

    public static WinningResult of(MatchResult matchResult) {
        return Arrays.stream(values())
                .filter(winningResult -> winningResult.parse(matchResult))
                .findFirst()
                .orElse(NOT_MATCH);
    }

    private boolean parse(MatchResult matchResult) {
        boolean isSameCount = (matchCount == matchResult.getMatchCount());
        if (this == SECOND) {
            return isSameCount && (matchBonus == matchResult.matchBonus());
        }
        return isSameCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public int getPrice() {
        return price;
    }
}
