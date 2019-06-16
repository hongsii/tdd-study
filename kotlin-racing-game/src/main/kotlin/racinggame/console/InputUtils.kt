package racinggame.console

object InputUtils {

    fun inputDriversWithComma(): String = input("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).") { readLine()!! }
    fun inputTrialCount() = input("시도할 회수는 몇 회 인가요?") { readLine()!!.toInt() }

    private fun <T> input(displayMessage: String, inputFunction: () -> T): T {
        while (true) {
            try {
                println(displayMessage)
                return inputFunction.invoke()
            } catch (e: Exception) {
                println("잘못 입력하셨습니다.")
            }
        }
    }
}
