package dev.hongsii.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinningAnalyzer {

    private List<WinningResult> winningResults;

    public WinningAnalyzer(List<WinningResult> winningResults) {
        this.winningResults = winningResults;
    }

    public Map<WinningResult, Integer> analyzeByWinningResult() {
        Map<WinningResult, Integer> statistics = initializeStatistics();
        calculateWinningCount(statistics);
        return statistics;
    }

    private Map<WinningResult, Integer> initializeStatistics() {
        Map<WinningResult, Integer> statistics = new LinkedHashMap<>(WinningResult.values().length);
        for (WinningResult winningResult : WinningResult.values()) {
            statistics.put(winningResult, 0);
        }
        return statistics;
    }

    private void calculateWinningCount(Map<WinningResult, Integer> statistics) {
        for (WinningResult winningResult : winningResults) {
            statistics.put(winningResult, statistics.get(winningResult) + 1);
        }
    }

    public int calculateTotalPrice() {
        return winningResults.stream()
                .mapToInt(WinningResult::getPrice)
                .sum();
    }
}
