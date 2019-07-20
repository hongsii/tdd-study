package laddergame.domain.ladder.strategy

import java.util.*

class RandomGenerationStrategy : GenerationStrategy {

    override fun canGenerate() = random.nextBoolean()

    companion object {

        private val random = Random()
    }
}