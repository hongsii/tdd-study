package baseballgame.model

class BaseballGame(
    private val answer: Numbers,
    private val _history: MutableList<GuessResult>
) {

    val history: List<GuessResult> get() =  _history

    constructor(answer: Numbers) : this(answer, mutableListOf())

    fun guess(rawGuessNumbers: String): GuessResult {
        val guessNumbers = Numbers.from(rawGuessNumbers)
        return GuessResult(guessNumbers.numbers, answer.match(guessNumbers))
            .also { _history.add(it) }
    }
}