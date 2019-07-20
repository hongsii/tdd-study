package laddergame.domain.ladder.strategy

class BooleanGenerationStrategy(private val canGenerate: Boolean) :
    GenerationStrategy {

    override fun canGenerate() = canGenerate

    companion object {

        val ALWAYS_GENERATION = BooleanGenerationStrategy(true)
        val NEVER_GENERATION = BooleanGenerationStrategy(false)
    }
}