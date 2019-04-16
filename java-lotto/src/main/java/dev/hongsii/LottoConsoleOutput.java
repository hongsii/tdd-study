package dev.hongsii;

import dev.hongsii.model.Lotto;
import dev.hongsii.model.WinningAnalyzer;
import dev.hongsii.model.WinningLotto;
import dev.hongsii.model.WinningResult;

import java.util.List;
import java.util.Map;

public class LottoConsoleOutput {

    public static void printWinningLotto(WinningLotto winningLotto) {
        System.out.println("\n---------- 당첨번호 ----------\n");
        System.out.println(winningLotto);
    }

    public static void printBuyingLotto(List<Lotto> lottos) {
        System.out.println("\n--------- 구매한 로또 ---------\n");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void print(WinningAnalyzer winningAnalyzer) {
        System.out.println("\n------------ 결과 -----------\n");
        Map<WinningResult, Integer> winningResults = winningAnalyzer.analyzeByWinningResult();
        for (Map.Entry<WinningResult, Integer> result : winningResults.entrySet()) {
            String message = getMessage(result);
            System.out.println(message);
        }
        System.out.println("\n----------------------------\n");

        System.out.println("총 당첨금 : " + winningAnalyzer.calculateTotalPrice());
    }

    private static String getMessage(Map.Entry<WinningResult, Integer> result) {
        WinningResult winningResult = result.getKey();
        if (winningResult.isMatchBonus()) {
            return String.format("%d개 일치 + 보너스 (%d) - %d",
                    winningResult.getMatchCount(), winningResult.getPrice(), result.getValue());
        }
        if (winningResult == WinningResult.NOT_MATCH) {
            return String.format("꽝 (%d) - %d", winningResult.getPrice(), result.getValue());
        }
        return String.format("%d개 일치 (%d) - %d",
                winningResult.getMatchCount(), winningResult.getPrice(), result.getValue());
    }
}