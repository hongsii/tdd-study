package racinggame.model

class PositionRecorder(val positions: List<Position>) {

    fun getWinners(): List<String> {
        if (positions.isEmpty()) return emptyList()
        val maxPosition = findMaxPosition()
        return findNamesOfWinner(maxPosition)
    }

    private fun findMaxPosition(): Position =
        positions
            .maxBy { it.position }!!

    private fun findNamesOfWinner(maxPosition: Position): List<String> =
        positions
            .filter(maxPosition::isSamePosition)
            .map { it.driver }
}
