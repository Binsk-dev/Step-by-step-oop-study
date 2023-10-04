package pocketmon.turn.factory;

import pocketmon.Player;
import pocketmon.turn.attackTurn.AttackNoChangeUntilDieTurn;
import pocketmon.turn.AttackTurn;
import pocketmon.turn.AttackTurnAbstractFactory;

public class AttackNoChangeUntilDieTurnFactory extends AttackTurnAbstractFactory {
    public AttackNoChangeUntilDieTurnFactory(){}

    @Override
    public AttackTurn createTurn(Player attacker, Player defender) {
        return new AttackNoChangeUntilDieTurn(attacker, defender);
    }
}
