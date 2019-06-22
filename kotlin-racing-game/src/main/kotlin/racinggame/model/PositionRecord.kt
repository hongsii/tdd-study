package racinggame.model

data class PositionRecord(val positions: List<Position>) {

    fun getWinners(): List<String> {
        if (positions.isEmpty()) return emptyList()
        val maxPosition = findMaxPosition()
        return findWinners(maxPosition)
    }

    private fun findMaxPosition(): Position =
        positions
            .maxBy { it.position }!!

    private fun findWinners(maxPosition: Position): List<String> =
        positions
            .filter(maxPosition::isSamePosition)
            .map { it.driver }
}
