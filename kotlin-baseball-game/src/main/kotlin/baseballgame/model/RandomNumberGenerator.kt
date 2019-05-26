package baseballgame.model

object RandomNumberGenerator {

    fun generateWith(numberSize: Int): Numbers =
        (Number.MIN..Number.MAX)
            .shuffled()
            .take(numberSize)
            .let { Numbers.of(it) }
}