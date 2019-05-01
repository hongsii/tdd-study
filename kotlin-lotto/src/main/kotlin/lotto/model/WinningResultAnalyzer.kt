package lotto.model

class WinningResultAnalyzer(private val winningResults: List<WinningResult>) {

    fun getWinningCountFromResult(): Map<WinningResult, Int> {
        return WinningResult.values()
            .map { key -> key to winningResults.count { key == it } }
            .toMap()
    }
}