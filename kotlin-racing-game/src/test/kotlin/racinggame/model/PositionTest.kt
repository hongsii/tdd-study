package racinggame.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class PositionTest {

    @ParameterizedTest(name = "[{index}] : {0} == {1} => {2}")
    @CsvSource(value = [
        "1, 1, true",
        "1, 2, false"
    ])
    fun isSamePosition(position1: Int, position2: Int, expected: Boolean) {
        val target = Position("1", position1)
        val other = Position("1", position2)

        val actual = target.isSamePosition(other)

        assertThat(actual).isEqualTo(expected)
    }
}