package lotto

import lotto.model.LottoGenerator

fun main() {
    val buyingCount = inputBuyingCount()

    val lottoGenerator = LottoGenerator()
    lottoGenerator.generate(buyingCount)
}

fun inputBuyingCount(): Int {
    return input("로또 개수 : ") { readLine()!!.toInt() }
}

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