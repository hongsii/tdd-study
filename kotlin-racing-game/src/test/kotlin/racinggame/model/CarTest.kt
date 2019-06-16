package racinggame.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import racinggame.model.Car.Companion.MAX_CONDITION
import racinggame.model.Car.Companion.MIN_CONDITION
import racinggame.model.Car.Companion.MOVE_CONDITION

class CarTest {

    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car()
    }

    @DisplayName("If value is more than move condition($MOVE_CONDITION), car move")
    @ParameterizedTest(name = "[{index}] : value = {0} -> position +{1}")
    @MethodSource
    fun move(value: Int, expected: Int) {
        val position = car.move(value)

        assertThat(position).isEqualTo(expected)
    }

    @DisplayName("If value is out of range($MIN_CONDITION~$MAX_CONDITION), throw exception")
    @ParameterizedTest(name = "[{index}] : value = {0}")
    @MethodSource
    fun moveByInvalidValue(value: Int) {
        assertThatIllegalArgumentException().isThrownBy { car.move(value) }
    }

    companion object Fixture {

        @JvmStatic
        fun move()= listOf(
            arguments(MOVE_CONDITION + 1, 1),
            arguments(MOVE_CONDITION, 1),
            arguments(MOVE_CONDITION - 1, 0)
        )

        @JvmStatic
        fun moveByInvalidValue()= listOf(
            arguments(MAX_CONDITION + 1),
            arguments(MIN_CONDITION - 1)
        )
    }
}