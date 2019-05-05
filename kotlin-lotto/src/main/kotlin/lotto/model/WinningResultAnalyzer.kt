package lotto.model

import kotlin.math.roundToInt

class WinningResultAnalyzer(private val winningResults: List<WinningResult>) {

    fun getWinningCountFromResult(): Map<WinningResult, Int> {
        return WinningResult.values()
            .map { key -> key to winningResults.count { key == it } }
            .toMap()
    }

    fun calculateWinningMoney(): Int {
        return winningResults.sumBy { it.winningMoney }
    }

    fun calculateProfitRate(pricePerLotto: Int): Int {
        val totalBuyingMoney = winningResults.size * pricePerLotto
        val winningMoney = calculateWinningMoney().toDouble()
        return (((winningMoney - totalBuyingMoney) / totalBuyingMoney) * 100).roundToInt()
    }
}