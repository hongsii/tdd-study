package laddergame.domain

import laddergame.domain.info.Players
import laddergame.domain.info.Results
import laddergame.domain.ladder.Ladder

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