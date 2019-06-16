package racinggame.model

data class RacingResult(val moveResults: List<MoveResult>) {

    fun getTrialCount() = moveResults.size
}

data class MoveResult(val positions: List<Int>)