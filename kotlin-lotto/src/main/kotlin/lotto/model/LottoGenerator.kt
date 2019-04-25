package lotto.model

object LottoGenerator {

    fun generateWinningLotto(): WinningLotto {
        val numbers = RandomNumberPicker.pick(Lotto.SIZE + 1)
        return WinningLotto(Lotto(numbers.take(Lotto.SIZE)), numbers.last())
    }

    fun generate(count: Int): List<Lotto> {
        return (1..count)
            .map { generate() }
            .toList()
    }

    fun generate(): Lotto {
        return Lotto(RandomNumberPicker.pick(Lotto.SIZE))
    }
}
