package lotto.model

object RandomNumberPicker {

    private val numbers = (Number.MIN..Number.MAX).map { Number(it) }.toList()

    fun pick(count: Int): List<Number> {
        return numbers
            .shuffled()
            .take(count)
            .toList()
    }
}