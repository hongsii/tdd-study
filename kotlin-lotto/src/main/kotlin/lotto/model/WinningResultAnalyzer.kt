package lotto.model

class WinningResultAnalyzer(private val winningResults: List<WinningResult>) {

    fun getWinningCountFromResult(): Map<WinningResult, WinningSummary> = WinningResult.values()
        .map { key ->
            val winningCount = winningResults.count { key == it }
            key to WinningSummary(winningCount, calculateWinningPercentage(winningCount))
        }
        .toMap()

    private fun calculateWinningPercentage(winningCount: Int): Double = (winningCount.toDouble() / winningResults.size) * 100

    fun calculateWinningMoney(): Int = winningResults.sumBy { it.winningMoney }

    fun calculateProfitRate(pricePerLotto: Int): Double {
        val totalBuyingMoney = winningResults.size * pricePerLotto
        val winningMoney = calculateWinningMoney().toDouble()
        return (((winningMoney - totalBuyingMoney) / totalBuyingMoney) * 100)
    }
}

data class WinningSummary(val winningCount: Int, val percentage: Double)
