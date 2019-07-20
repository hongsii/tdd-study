package laddergame.view

object InputView {

    fun inputPlayers() = input("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)") { readString() }
    fun inputResults() = input("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)") { readString() }
    fun inputHeight() = input("최대 사다리 높이는 몇 개인가요?") { readString().toInt() }
    fun inputExpectedResult() = input("결과를 보고 싶은 사람은?") { readString() }

    private fun readString() = readLine()!!

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