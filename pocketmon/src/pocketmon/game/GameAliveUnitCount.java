package pocketmon.game;

import pocketmon.Game;
import pocketmon.Player;
import pocketmon.turn.AttackTurnAbstractFactory;

public class GameAliveUnitCount extends Game {
    public GameAliveUnitCount(Player player1, Player player2, AttackTurnAbstractFactory attackTurnFactory) {
        super(player1, player2, attackTurnFactory);
    }

    @Override
    protected Player getWinner() {
        if (player1.getAliveUnitCount() > 0) {
            return player1;
        } else if (player2.getAliveUnitCount() > 0) {
            return player2;
        }
        return null;
    }
}
