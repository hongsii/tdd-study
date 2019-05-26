package baseballgame.model

object RandomNumberGenerator {

    fun generateWith(numberSize: Int): Numbers = (1..numberSize)
        .map { generate() }
        .let { Numbers(it) }

    private fun generate(): Number = (Number.MIN..Number.MAX)
        .random()
        .let { Number.of(it) }
}