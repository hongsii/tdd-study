package dev.hongsii.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {

    private Lotto winningLotto;

    public WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public WinningAnalyzer win(List<Lotto> lottos) {
        return new WinningAnalyzer(
                lottos.stream()
                        .map(this::win)
                        .collect(Collectors.toList())
        );
    }

    public WinningResult win(Lotto lotto) {
        int matchCount = winningLotto.match(lotto);
        boolean matchBonus = winningLotto.matchBonus(lotto);
        return WinningResult.of(new MatchResult(matchCount, matchBonus));
    }

    @Override
    public String toString() {
        return winningLotto.toString();
    }
}
