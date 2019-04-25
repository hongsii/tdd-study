package lotto

import lotto.model.Lotto
import lotto.model.LottoGenerator
import lotto.model.WinningLotto

fun main() {
    val buyingCount = inputBuyingCount()

    val winningLotto = LottoGenerator.generateWinningLotto()
    val ticket = LottoGenerator.generate(buyingCount)

    displayWinningLotto(winningLotto)
    displayTicket(ticket)
}

fun inputBuyingCount(): Int = input("로또 개수 : ") { readLine()!!.toInt() }
fun displayTicket(ticket: List<Lotto>) = ticket.forEach { println("${makeLottoForDisplay(it)}") }
fun displayWinningLotto(winningLotto: WinningLotto) = println("${makeLottoForDisplay(winningLotto.getLotto())} + ${winningLotto.getBonusNumber().number}")
private fun makeLottoForDisplay(lotto: Lotto) = lotto.getNumbers().map { "%2d".format(it.number) }.joinToString(" ")


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
