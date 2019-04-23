package lotto.model

import spock.lang.Specification

class LottoGeneratorTest extends Specification {

    LottoGenerator lottoGenerator

    void setup() {
        lottoGenerator = new LottoGenerator()
    }

    def "generate Lotto by random numbers"() {
        expect:
        lottoGenerator.generate() != null
    }

    def "generate Lotto as count"() {
        given:
        def count = 5

        when:
        def ticket = lottoGenerator.generate(5)

        then:
        ticket.size() == count
    }
}