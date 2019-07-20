package laddergame.domain.ladder

data class Players(private val players: List<Player>) : Indexer<Player> {

    init {
        require(players.size >= MIN_PLAYER_COUNT){ "최소 ${MIN_PLAYER_COUNT}명이 필요합니다. " }
    }

    fun findIndexByPlayerName(playerName: String) =
        players.indexOf(Player(playerName))
            .takeIf { it != NOT_FOUND_INDEX }
            ?: throw IllegalArgumentException("플레이어를 찾을 수 없습니다.")

    fun size() = players.size

    fun getPlayers() = players

    override fun get(index: Int): Player = players[index]

    companion object {

        const val MIN_PLAYER_COUNT = LadderLine.MIN_POINT_COUNT
        const val NOT_FOUND_INDEX = -1

        fun fromComma(rawPlayers: String): Players =
            rawPlayers.split(",")
                .map { Player(it) }
                .let { Players(it) }
    }
}