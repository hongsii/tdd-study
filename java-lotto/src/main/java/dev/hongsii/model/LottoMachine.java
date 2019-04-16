package dev.hongsii.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private RandomLottoGenerator lottoGenerator;

    public LottoMachine(RandomLottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> buy(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() < lottoCount) {
            lottos.add(lottoGenerator.generate());
        }
        return lottos;
    }

    public WinningLotto generateWinningLotto() {
        return new WinningLotto(lottoGenerator.generate());
    }
}
