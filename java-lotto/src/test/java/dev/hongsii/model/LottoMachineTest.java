package dev.hongsii.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @Before
    public void setUp() {
        lottoMachine = new LottoMachine(new RandomLottoGenerator());
    }

    @Test
    public void buy() {
        int lottoCount = 5;
        List<Lotto> lottos = lottoMachine.buy(lottoCount);

        assertThat(lottos).hasSize(lottoCount);
    }

    @Test
    public void createWinningLotto() {
        assertThat(lottoMachine.generateWinningLotto()).isNotNull();
    }
}