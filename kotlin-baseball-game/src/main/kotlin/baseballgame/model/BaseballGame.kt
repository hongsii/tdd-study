package baseballgame.model

class BaseballGame(
    private val answer: Numbers,
    private val _history: MutableList<GuessResult>
) {

    val history: List<GuessResult> get() =  _history

    constructor(answer: Numbers) : this(answer, mutableListOf())

    fun guess(rawGuessNumbers: String): GuessResult =
        Numbers.from(rawGuessNumbers)
            .let { GuessResult(it.numbers, answer.match(it)) }
            .also { _history.add(it) }
}