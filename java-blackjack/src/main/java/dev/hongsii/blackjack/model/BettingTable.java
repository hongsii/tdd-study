package dev.hongsii.blackjack.model;

import java.util.HashMap;
import java.util.Map;

public class BettingTable {

    private Map<Player, Integer> table = new HashMap<>();

    public void bet(Player player, Integer bettingMoney) {
        table.put(player, bettingMoney);
    }

    public int getBettingMoney(Player player) {
        return table.get(player);
    }
}
