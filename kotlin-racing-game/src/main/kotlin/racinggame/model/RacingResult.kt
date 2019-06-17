package racinggame.model

data class RacingResult(val allPositionRecord: List<PositionRecord>) {

    fun getWinners() = allPositionRecord.last().getWinners()
}
data class PositionRecord(val positions: List<Position>) {

    fun getWinners(): List<String> =
        positions
            .map { it.position }
            .max()
            .let { maxPosition ->
                positions
                    .filter { maxPosition == it.position }
                    .map { it.driver }
            }

    companion object {

        @JvmStatic
        fun from(cars: List<Car>): PositionRecord =
            cars
                .map { Position.of(it) }
                .let { PositionRecord(it) }
    }
}
