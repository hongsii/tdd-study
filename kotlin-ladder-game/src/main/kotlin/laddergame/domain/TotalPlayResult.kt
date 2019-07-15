package laddergame.domain

data class TotalPlayResult(private val resultByPlayer: Map<Player, String>) {

    fun getAllResult() = resultByPlayer
}