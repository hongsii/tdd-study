package racinggame.model

class PositionRecorder(val positions: List<Position>) {

    fun getWinners(): List<String> =
        findMaxPosition()
            ?.let { findNamesOfWinner(it) }
            ?: emptyList()

    private fun findMaxPosition(): Position? = positions.max()

    private fun findNamesOfWinner(maxPosition: Position): List<String> =
        positions
            .filter(maxPosition::isSamePosition)
            .map { it.driver }
}