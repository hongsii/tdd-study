package lotto

import lotto.model.LottoGenerator
import lotto.model.WinningResult
import lotto.model.WinningResultAnalyzer

fun main() {
    val buyingCount = inputBuyingCount()

    val winningLotto = LottoGenerator.generateWinningLotto()
    val ticket = LottoGenerator.generate(buyingCount)

    val winningResults = ticket
        .map { winningLotto.win(it) }
        .toList()
    val winningResultAnalyzer = WinningResultAnalyzer(winningResults)
    val pricePerLotto = inputPricePerLotto()
    displaySummary(winningResultAnalyzer.getWinningCountFromResult())
    displayWinningMoney(winningResultAnalyzer.calculateWinningMoney())
    displayProfitRate(winningResultAnalyzer.calculateProfitRate(pricePerLotto))
}

fun inputBuyingCount(): Int = inputNumber("로또 개수 : ")
fun inputPricePerLotto(): Int = inputNumber("한장당 가격 : ")
fun inputNumber(message: String): Int = input(message) { readLine()!!.toInt() }
private fun <T> input(message: String, operation: () -> T): T {
    while (true) {
        try {
            print(message)
            return operation.invoke()
        } catch (e: Exception) {
            println("잘못된 입력입니다.")
        }
    }
}

fun displaySummary(winningCounter: Map<WinningResult, Int>) = winningCounter.entries.forEach { println("${WinningResultCharacter.valueOf(it.key.toString())} : ${it.value}") }
fun displayWinningMoney(calculateWinningMoney: Int) = println("\n당첨 금액 : $calculateWinningMoney")
fun displayProfitRate(profitRate: Int) = println("수익률 : $profitRate%")

enum class WinningResultCharacter(val character: String) {

    FIRST("1등"), SECOND("2등"), THIRD("3등"), FOURTH("4등"), FIFTH("5등"), NONE("꽝!");

    override fun toString() = character
}
