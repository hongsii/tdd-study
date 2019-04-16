package dev.hongsii.blackjack;

import dev.hongsii.blackjack.io.ConsoleInput;
import dev.hongsii.blackjack.io.ConsoleOutput;
import dev.hongsii.blackjack.model.BlackjackGame;
import dev.hongsii.blackjack.model.Dealer;
import dev.hongsii.blackjack.model.Player;

public class BlackjackGameConsole {

    public static void main(String[] args) {
        int countOfPlayer = ConsoleInput.inputCountOfPlayer();
        BlackjackGame blackjackGame = BlackjackGame.initializeWithSingleDeck(countOfPlayer);

        while (true) {
            // 플레이어가 배팅한다.
            for (Player player : blackjackGame.getPlayers()) {
                blackjackGame.betOnTable(player, ConsoleInput.inputBettingMoney(player));
            }

            // 딜러와 각 플레이어는 카드를 각각 두장씩 뽑는다.
            ConsoleOutput.printVerticalLine();
            blackjackGame.deal(blackjackGame.getDealer());
            ConsoleOutput.displayHandOfDealerOnlyOneCard(blackjackGame.getDealer());
            for (Player player : blackjackGame.getPlayers()) {
                blackjackGame.deal(player);
                ConsoleOutput.displayHandOfPlayer(player);
            }

            // 추가로 카드 뽑기
            hitFromDealer(blackjackGame);
            for (Player player : blackjackGame.getPlayers()) {
                ConsoleOutput.printVerticalLine();
                hitFromPlayer(blackjackGame, player);
            }

            // 결과를 확인한다.
            ConsoleOutput.printVerticalLine();
            ConsoleOutput.displayHandOfDealer(blackjackGame.getDealer());
            for (Player player : blackjackGame.getPlayers()) {
                ConsoleOutput.displayHandOfPlayer(player);
                ConsoleOutput.displayResult(blackjackGame.winToDealer(player));
                ConsoleOutput.printVerticalLine();
            }
        }
    }

    private static void hitFromPlayer(BlackjackGame blackjackGame, Player player) {
        while (player.canReceive()) {
            ConsoleOutput.printNewline();
            ConsoleOutput.displayHandOfPlayer(player);
            boolean hit = ConsoleInput.inputPlayerInputForHit(player);
            if (!hit) break;

            blackjackGame.hit(player);
        }
    }

    private static void hitFromDealer(BlackjackGame blackjackGame) {
        Dealer dealer = blackjackGame.getDealer();
        while (dealer.canReceive()) {
            blackjackGame.hit(dealer);
        }
    }

}
