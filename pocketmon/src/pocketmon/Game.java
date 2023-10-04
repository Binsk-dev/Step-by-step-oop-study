package pocketmon;

import pocketmon.turn.AttackTurnAbstractFactory;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Player player1;
    private final Player player2;
    private final List<Turn> turnList;
    private final AttackTurnAbstractFactory attackTurnFactory;


    Game(Player player1, Player player2, AttackTurnAbstractFactory attackTurnFactory) {
        this.player1 = player1;
        this.player2 = player2;
        this.turnList = new ArrayList<>();
        this.attackTurnFactory = attackTurnFactory;
    }

    public void start() {
        System.out.println("======================== Game Start ========================");
        System.out.println(player1.getName() + " 와(과) " + player2.getName() + " 의 세기의 대결! 시작합니다!!");

        int i = 0;
        while (isNotEnd()) {
            // TODO: 다른 type의 turn도 고려할 수 있도록 수정해야 함
            System.out.println("\nTurn " + ++i);

            player1.showCurrentUnitStatus();
            player2.showCurrentUnitStatus();
            System.out.println();

            Turn turn;
            if (i % 2 == 0) {
                turn = attackTurnFactory.createTurn(player1, player2);
            } else {
                turn = attackTurnFactory.createTurn(player2, player1);
            }
            turn.runTurn();
            turnList.add(turn);
        }
        try {
            if (getWinner() != null) {
                System.out.println("\n대결의 승자는!! " + getWinner().getName());
            } else {
                System.out.println("\n대결은 무승부로 끝났습니다!!");
            }
            System.out.println("======================== Game End  ========================");
        } catch (Exception e) {
            System.out.println("!!!!!!!!!!!!!!!!!!!! Game이 비정상적으로 종료되었습니다. !!!!!!!!!!!!!!!!!!!!");
        }
    }

    protected boolean isNotEnd() {
        return this.player1.getRemainUnitCount() > 0 && this.player2.getRemainUnitCount() > 0;
    }

    private Player getWinner() throws Exception {
        if (isNotEnd()) {
            throw new Exception();
        }
        if (player1.getRemainUnitCount() > 0) {
            return player1;
        } else if (player2.getRemainUnitCount() > 0) {
            return player2;
        }
        return null;
    }

}
