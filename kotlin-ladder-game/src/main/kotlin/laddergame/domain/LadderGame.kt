package laddergame.domain

import laddergame.domain.ladder.Ladder
import laddergame.domain.ladder.Players
import laddergame.domain.ladder.Results

class LadderGame(
    val players: Players,
    val results: Results,
    val ladder: Ladder
) {

    fun move(playerName: String): PlayResult =
        players.findIndexByPlayerName(playerName)
            .let {
                val indexOfPlayer = ladder.move(it)
                PlayResult(playerName = playerName, result = results[indexOfPlayer])
            }

    fun moveAll(): TotalPlayResult =
        (0 until players.size())
            .map { players[it] to results[ladder.move(it)] }
            .let { TotalPlayResult(it.toMap()) }
}