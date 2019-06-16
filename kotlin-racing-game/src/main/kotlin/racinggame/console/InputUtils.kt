package racinggame.console

object InputUtils {

    fun inputCountOfCars(): Int = inputNumberWithMessage("자동차 대수는 몇 대 인가요?")
    fun inputTrialCount() = inputNumberWithMessage("시도할 회수는 몇 회 인가요?")

    private fun inputNumberWithMessage(displayMessage: String): Int {
        while (true) {
            try {
                println(displayMessage)
                return readLine(

                )!!.toInt()
            } catch (e: Exception) {
                println("잘못 입력하셨습니다.")
            }
        }
    }
}
