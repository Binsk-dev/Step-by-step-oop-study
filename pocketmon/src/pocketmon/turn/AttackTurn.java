package pocketmon.turn;

import pocketmon.Player;
import pocketmon.Turn;

public abstract class AttackTurn extends Turn {
    protected Player attacker;
    protected Player defender;

    /**
     * attacker의 unit은 죽을때까지 교체하지 않는 turn
     *
     * @param attacker 공격하는 Player
     * @param defender 방어하는 Player
     */
    public AttackTurn(Player attacker, Player defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public void startTurn() {
        // player1이 player2를 공격하도록 요청
        attacker.attack(defender);
    }

    public abstract void endTurn();
}
