package dev.hongsii.model;

import java.util.*;

public class MatchResult {

    private List<ResultType> resultTypes;

    private MatchResult(List<ResultType> resultTypes) {
        this.resultTypes = resultTypes;
    }

    public static MatchResult init() {
        return of(new ArrayList<>());
    }

    public static MatchResult of(List<ResultType> resultTypes) {
        return new MatchResult(resultTypes);
    }

    public void record(boolean isCorrectDigit, boolean isCorrectPosition) {
        resultTypes.add(ResultType.of(isCorrectDigit, isCorrectPosition));
    }

    public boolean isAllStrike() {
        return resultTypes.stream()
                .allMatch(resultType -> resultType == ResultType.STRIKE);
    }

    public Map<ResultType, Integer> getCountByResult() {
        Map<ResultType, Integer> results = new LinkedHashMap<>();
        for (ResultType resultType : resultTypes) {
            results.put(resultType, results.getOrDefault(resultType, 0) + 1);
        }
        return Collections.unmodifiableMap(results);
    }

    public List<ResultType> getResultTypes() {
        return Collections.unmodifiableList(resultTypes);
    }
}
