package dev.hongsii.model;

import java.util.Map;

public class GuessResult {

    private int guessCount;
    private MatchResult matchResult;

    public GuessResult(int guessCount, MatchResult matchResult) {
        this.guessCount = guessCount;
        this.matchResult = matchResult;
    }

    public int getGuessCount() {
        return guessCount;
    }

    public MatchResult getMatchResult() {
        return matchResult;
    }

    public boolean isGameOver() {
        return matchResult.isAllStrike();
    }

    public String getDisplayResult() {
        Map<ResultType, Integer> countByResult = matchResult.getCountByResult();
        StringBuilder displayResult = new StringBuilder();
        for (ResultType resultType : ResultType.values()) {
            if (countByResult.containsKey(resultType)) {
                String format = String.format("%s%d",
                        resultType.getDisplayCharacter(), countByResult.get(resultType));
                displayResult.append(format);
            }
        }
        return displayResult.toString();
    }
}
