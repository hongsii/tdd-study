package racinggame.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource

class CarTest {

    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car()
    }

    @DisplayName("If value is more than move condition, car move")
    @ParameterizedTest(name = "[{index}] : value = {0} -> position = {1}")
    @MethodSource
    fun move(value: Int, expected: Int) {
        val position = car.move(value)

        assertThat(position).isEqualTo(expected)
    }

    @DisplayName("Value must be in valid range")
    @ParameterizedTest(name = "[{index}] : value = {0}")
    @MethodSource
    fun moveByInvalidValue(value: Int) {
        assertThatIllegalArgumentException().isThrownBy { car.move(value) }
    }

    companion object Fixture {

        @JvmStatic
        fun move()= listOf(
            arguments(Car.MOVE_CONDITION + 1, 1),
            arguments(Car.MOVE_CONDITION, 1),
            arguments(Car.MOVE_CONDITION - 1, 0)
        )

        @JvmStatic
        fun moveByInvalidValue()= listOf(
            arguments(Car.MAX_CONDITION + 1),
            arguments(Car.MIN_CONDITION - 1)
        )
    }
}