package lotto

import lotto.model.LottoSimulator
import lotto.model.SimulationOption
import lotto.model.WinningResult

fun main() {
    val simulationOperation = SimulationOption(
        lottoCount = inputLottoCount(),
        pricePerLotto = inputPricePerLotto()
    )
    val simulationResult = LottoSimulator.simulate(simulationOperation)
    displaySummary(simulationResult.winningSummary)
    displayWinningMoney(simulationResult.winningMoney)
    displayProfitRate(simulationResult.profitRate)
}

fun inputLottoCount(): Int = inputNumber("로또 개수 : ")
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
