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
}