package pocketmon.turn.factory;

import pocketmon.Player;
import pocketmon.turn.AttackTurn;
import pocketmon.turn.AttackTurnAbstractFactory;
import pocketmon.turn.attackTurn.AttackChangeAllUnitWhenAnyUnitDie;
import pocketmon.turn.attackTurn.AttackNoChangeUntilDieTurn;

public class AttackChangeAllUnitWhenAnyUnitDieFactory extends AttackTurnAbstractFactory {
    public AttackChangeAllUnitWhenAnyUnitDieFactory(){}

    @Override
    public AttackTurn createTurn(Player attacker, Player defender) {
        return new AttackChangeAllUnitWhenAnyUnitDie(attacker, defender);
    }
}
