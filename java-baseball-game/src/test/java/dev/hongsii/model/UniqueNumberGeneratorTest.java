package dev.hongsii.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UniqueNumberGeneratorTest {

    @Test
    public void generate() {
        UniqueNumberGenerator uniqueNumberGenerator = new UniqueNumberGenerator();

        int numberCount = 3;
        BaseballNumber baseballNumber = uniqueNumberGenerator.generate(numberCount);

        assertThat(baseballNumber.getNumbers()).hasSize(numberCount);
    }
}
