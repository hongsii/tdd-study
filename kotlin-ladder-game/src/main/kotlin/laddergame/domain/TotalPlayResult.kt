package laddergame.domain

import laddergame.domain.ladder.Player

data class TotalPlayResult(private val resultByPlayer: Map<Player, String>) {

    fun getAllResult() = resultByPlayer
}