package Pookimon;

import Pookimon.display.Display;
import Pookimon.duelable.Duelable;
import Pookimon.duelable.Player;

public class Duel{
    private Player home;
    private Duelable away;
    private Display display;

    public Duel(Player home, Duelable away, Display display) {
        this.home = home;
        this.away = away;
        this.display = display;
    }
    private void initiatePlayers(){
        home.init();
        away.init();
    }
    public void startDuel(){
        display.show(home.getName() + "과 " + away.getName()+ "이 대결을 시작했습니다.");
        initiatePlayers();
        Duelable a = home;
        Duelable b = away;
        display.show(a.getName() + "의 턴!");
        while(!a.attack(b)){
            Duelable tmp = a;
            a = b;
            b = tmp;
            display.show(a.getName() + "의 턴!");
        }
        display.show((a == home) ? "대결에서 승리했습니다!" : "눈 앞이 까마득해진다..");
    }
    private void swap(Duelable a, Duelable b){
        Duelable tmp = a;
        a = b;
        b = tmp;
    }
}
