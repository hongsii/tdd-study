package laddergame.domain.ladder.strategy

@FunctionalInterface
interface GenerationStrategy {

    fun canGenerate(): Boolean
}