package pocketmon.turn;

import pocketmon.Player;

public abstract class AttackTurnAbstractFactory {
    protected AttackTurnAbstractFactory() {
    }

    public abstract AttackTurn createTurn(Player attacker, Player defender);
}
