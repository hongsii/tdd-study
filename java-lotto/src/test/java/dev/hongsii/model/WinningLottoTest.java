package dev.hongsii.model;

import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    private WinningLotto winningLotto;

    @Before
    public void setUp() {
        Lotto lotto = LottoTest.createLotto();
        winningLotto = new WinningLotto(lotto);
    }

    @Test
    public void winFirst() {
        Lotto lotto = LottoTest.createLotto(asList(1, 2, 3, 4, 5, 6), 7);

        assertWinning(lotto, WinningResult.FIRST);
    }

    @Test
    public void winSecond() {
        Lotto lotto = LottoTest.createLotto(asList(1, 2, 3, 4, 5, 20), 7);

        assertWinning(lotto, WinningResult.SECOND);
    }

    @Test
    public void winThird() {
        Lotto lotto = LottoTest.createLotto(asList(1, 2, 3, 4, 5, 20), 21);

        assertWinning(lotto, WinningResult.THIRD);
    }

    @Test
    public void winFourth() {
        Lotto lotto = LottoTest.createLotto(asList(1, 2, 3, 4, 19, 20), 21);

        assertWinning(lotto, WinningResult.FOURTH);
    }

    @Test
    public void winFifth() {
        Lotto lotto = LottoTest.createLotto(asList(1, 2, 3, 18, 19, 20), 21);

        assertWinning(lotto, WinningResult.FIFTH);
    }

    @Test
    public void winWhenOnlyOneMatch() {
        Lotto lotto = LottoTest.createLotto(asList(1, 8, 9, 10, 11, 12), 13);

        assertWinning(lotto, WinningResult.NOT_MATCH);
    }

    private void assertWinning(Lotto lotto, WinningResult first) {
        assertThat(winningLotto.win(lotto)).isEqualTo(first);
    }
}
