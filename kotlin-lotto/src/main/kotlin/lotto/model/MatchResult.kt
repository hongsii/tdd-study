package lotto.model

data class MatchResult(val matchCount: Int, val matchBonusNumber: Boolean) {

    fun isSameMatchCount(matchResult: MatchResult): Boolean = matchCount == matchResult.matchCount
}
