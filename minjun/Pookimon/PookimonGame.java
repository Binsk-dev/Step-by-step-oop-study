package Pookimon;

import Pookimon.display.CLIDisplay;
import Pookimon.display.Display;
import Pookimon.duelable.Monster;
import Pookimon.duelable.Player;
import Pookimon.type.PlainType;

class PookimonGame {
    public static void main(String[] args){
        Display display = new CLIDisplay();
        Player jiwoo = new Player("지우", display);
        Player woong = new Player("웅", display);
        jiwoo.gotCha(new Monster("피카츄", 20, 100, new PlainType(), display));
        woong.gotCha(new Monster("롱스톤", 30, 300, new PlainType(), display));

        Duel duel1 = new Duel(jiwoo, woong, display);
        duel1.startDuel();

    }
}
