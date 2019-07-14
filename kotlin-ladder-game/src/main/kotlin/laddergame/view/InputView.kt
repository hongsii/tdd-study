package laddergame.view

object InputView {

    fun inputPlayers() = input("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)") { readLine()!! }
    fun inputHeight() = input("최대 사다리 높이는 몇 개인가요?") { readLine()!!.toInt() }

    private fun <T> input(displayMessage: String, inputFunction: () -> T): T {
        while (true) {
            try {
                println(displayMessage)
                return inputFunction()
            } catch (e: Exception) {
                println("잘못 입력하셨습니다.")
            }
        }
    }
}