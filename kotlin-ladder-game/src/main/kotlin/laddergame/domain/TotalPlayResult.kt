package laddergame.domain

import laddergame.domain.info.Player

data class TotalPlayResult(private val resultByPlayer: Map<Player, String>) {

    fun getPlayResults() =
        resultByPlayer.entries
            .map { PlayResult(playerName = it.key.name, result = it.value) }
}