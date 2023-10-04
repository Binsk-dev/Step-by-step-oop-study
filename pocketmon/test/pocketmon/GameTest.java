package pocketmon;

import pocketmon.game.GameAliveUnitCount;
import pocketmon.turn.factory.AttackChangeAllUnitWhenAnyUnitDieFactory;

public class GameTest {
    public static void main(String[] args) {
        UnitFactory unitFactory = new UnitFactory();
        Player player1 = new Player("지우", unitFactory.createRandomUnitList("지우", 5, 6));
        Player player2 = new Player("로이", unitFactory.createRandomUnitList("로이", 5, 6));

        Game game = new GameAliveUnitCount(
                player1,
                player2,
                new AttackChangeAllUnitWhenAnyUnitDieFactory()
                // new AttackNoChangeUntilDieTurnFactory()
        );

//        Game game = new GameTotalHP(
//                player1,
//                player2,
//                new AttackChangeAllUnitWhenAnyUnitDieFactory()
//                // new AttackNoChangeUntilDieTurnFactory()
//        );
        game.start();
    }
}
