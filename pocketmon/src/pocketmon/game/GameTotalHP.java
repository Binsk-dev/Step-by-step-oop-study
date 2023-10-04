package pocketmon.game;

import pocketmon.Game;
import pocketmon.Player;
import pocketmon.hitPoint.HitPoint;
import pocketmon.turn.AttackTurnAbstractFactory;

public class GameTotalHP extends Game {
    public GameTotalHP(Player player1, Player player2, AttackTurnAbstractFactory attackTurnFactory) {
        super(player1, player2, attackTurnFactory);
    }

    @Override
    protected Player getWinner() {
        HitPoint totalHitPointOfPlayer1 = player1.getTotalUnitHP();
        HitPoint totalHitPointOfPlayer2 = player2.getTotalUnitHP();
        if (totalHitPointOfPlayer1.isGreaterThan(totalHitPointOfPlayer2)) {
            return player1;
        } else if (totalHitPointOfPlayer1.isLessThan(totalHitPointOfPlayer2)) {
            return player2;
        }
        return null;
    }
}
