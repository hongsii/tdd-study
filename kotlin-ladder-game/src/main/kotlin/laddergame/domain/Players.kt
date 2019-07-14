package laddergame.domain

data class Players(private val players: List<Player>) {

    init {
        require(players.size >= MIN_PLAYER_COUNT){ "최소 ${MIN_PLAYER_COUNT}명이 필요합니다. " }
    }

    fun size() = players.size

    fun getPlayers() = players

    companion object {

        const val MIN_PLAYER_COUNT = LadderLine.MIN_POINT_COUNT

        fun fromComma(rawPlayers: String): Players =
            rawPlayers.split(",")
                .map { Player(it) }
                .run { Players(this) }
    }
}