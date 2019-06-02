package baseballgame.model

data class GuessResult(
    val trialNumbers: List<Number>,
    val matchResults: List<MatchResult>
) {

    fun win(): Boolean = matchResults.all { it == MatchResult.STRIKE }
    fun getCountOfEachMatchResult(): Map<MatchResult, Int> =
        MatchResult.values()
            .map { result -> result to matchResults.count { result == it } }
            .filter { it.second > 0 }
            .toMap()
}