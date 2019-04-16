package dev.hongsii;

import dev.hongsii.model.*;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(new RandomLottoGenerator());
        WinningLotto winningLotto = lottoMachine.generateWinningLotto();

        List<Lotto> lottos = lottoMachine.buy(LottoConsoleInput.inputLottoCount());
        WinningAnalyzer winningAnalyzer = winningLotto.win(lottos);

        LottoConsoleOutput.printWinningLotto(winningLotto);
        LottoConsoleOutput.printBuyingLotto(lottos);
        LottoConsoleOutput.print(winningAnalyzer);
    }
}
