package lotto.model

class LottoGenerator {

    private val numbers = (Number.MIN..Number.MAX).map { Number(it) }.toList()

    fun generate(count: Int): List<Lotto> {
        return (1..count)
            .map { generate() }
            .toList()
    }

    fun generate(): Lotto {
        return Lotto(pickRandomNumbers())
    }

    private fun pickRandomNumbers(): List<Number> {
        return numbers
            .shuffled()
            .take(Lotto.SIZE)
            .toList()
    }
}
