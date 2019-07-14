package laddergame.domain

import java.util.*

class RandomGenerationStrategy : GenerationStrategy {

    override fun canGenerate() = random.nextBoolean()

    companion object {

        private val random = Random()
    }
}