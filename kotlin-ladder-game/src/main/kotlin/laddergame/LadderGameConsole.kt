package laddergame

import laddergame.domain.Ladder
import laddergame.domain.RandomGenerationStrategy
import laddergame.view.InputView
import laddergame.view.OutputView

fun main() {
    val players = InputView.inputPlayers()
        .split(",")
        .toList()
    val height = InputView.inputHeight()

    val ladder = Ladder.of(height = height, width = players.size, generationStrategy = RandomGenerationStrategy())

    OutputView.printPlayers(players)
    OutputView.printLadder(ladder)
}
