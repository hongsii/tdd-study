package racinggame.model

data class RacingResult(val racingResult: List<PositionRecorder>) {

    fun getWinners() = racingResult.last().getWinners()
}
