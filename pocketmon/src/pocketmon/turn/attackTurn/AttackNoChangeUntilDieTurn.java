package pocketmon.turn.attackTurn;

import pocketmon.Player;
import pocketmon.turn.AttackTurn;

public class AttackNoChangeUntilDieTurn extends AttackTurn {
    /**
     * attacker의 unit은 죽을때까지 교체하지 않는 turn
     *
     * @param attacker 공격하는 Player
     * @param defender 방어하는 Player
     */
    public AttackNoChangeUntilDieTurn(Player attacker, Player defender) {
        super(attacker, defender);
    }

    public void endTurn() {
        // player2의 unit이 살아 있는지 확인 죽어있다면 다음 unit으로 변경하도록 요청
        if(defender.isCurrentUnitAlive()) {
            return;
        }

        defender.skipToNextUnit();
    }
}
