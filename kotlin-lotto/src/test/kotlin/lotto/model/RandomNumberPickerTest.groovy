package lotto.model

import spock.lang.Specification

class RandomNumberPickerTest extends Specification {

    def "get random numbers as count"() {
        when:
        def numbers = RandomNumberPicker.INSTANCE.pick(count)

        then:
        numbers.size() == count

        where:
        count | _
        1     | _
        5     | _
        6     | _
    }
}
