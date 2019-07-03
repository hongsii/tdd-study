package laddergame.domain

@FunctionalInterface
interface GenerationStrategy {

    fun canGenerate(): Boolean
}