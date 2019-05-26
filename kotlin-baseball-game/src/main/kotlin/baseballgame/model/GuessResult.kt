package baseballgame.model

data class GuessResult(
    val trialNumbers: List<Number>,
    val matchResults: List<MatchResult>
) {

    fun win(): Boolean = matchResults.all { it == MatchResult.STRIKE }
}