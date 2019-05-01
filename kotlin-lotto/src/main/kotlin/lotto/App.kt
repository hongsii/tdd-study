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
    displaySummary(winningResultAnalyzer.getWinningCountFromResult())
}

fun inputBuyingCount(): Int = input("로또 개수 : ") { readLine()!!.toInt() }
fun <T> input(message: String, operation: () -> T): T {
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

enum class WinningResultCharacter(val character: String) {

    FIRST("1등"), SECOND("2등"), THIRD("3등"), FOURTH("4등"), FIFTH("5등"), NONE("꽝!");

    override fun toString() = character
}
