package racinggame.model

data class RacingResult(val allPositionRecord: List<PositionRecord>) {

    fun getWinners() = allPositionRecord.last().getWinners()
}
