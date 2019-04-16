package dev.hongsii.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLottoGeneratorTest {

    @Test
    public void generate() {
        RandomLottoGenerator randomLottoGenerator = new RandomLottoGenerator();

        for (int i = 0; i < 100; i++) {
            assertThat(randomLottoGenerator.generate()).isNotNull();
        }
    }
}