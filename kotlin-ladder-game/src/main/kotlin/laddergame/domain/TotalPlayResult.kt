package laddergame.domain

import laddergame.domain.ladder.Player

data class TotalPlayResult(private val resultByPlayer: Map<Player, String>) {

    fun getPlayResults() =
        resultByPlayer.entries
            .map { PlayResult(playerName = it.key.name, result = it.value) }
}