package Pookimon.duelable;

import Pookimon.display.Display;

import java.util.ArrayList;

public class Player implements Duelable{
    final int MONSTER_MAX_NUM = 3;
    private String playerName;
    private ArrayList<Monster> monsterArrayList;
    private int currentMonsterIdx;
    private Display display;

    public Player(String playerName, Display display) {
        this.playerName = playerName;
        monsterArrayList = new ArrayList<>();
        currentMonsterIdx = 0;
        this.display = display;
    }
    @Override
    public String getName(){
        return playerName + "님";
    }
    public boolean gotCha(Monster monster){
        if(monsterArrayList.size() == MONSTER_MAX_NUM) return false;
        monsterArrayList.add(monster);
        return true;
    }
    @Override
    public void init(){
        currentMonsterIdx = 0;
        for(Monster monster : monsterArrayList){
            monster.init();
        }
        display.show(playerName + ": " + "가라! " + getCurrentMonster().getName() + "!");
    }
    @Override
    public boolean attack(Duelable defender){
        Monster monster = getCurrentMonster();
        display.show("공격 포켓몬 \n" + monster.getStatus());
        display.show(playerName + ": " + monster.getName() + "! 공격!");
        return defender.attacked(monster);
    }
    @Override
    public boolean attacked(Monster attackerMonster){
        Monster defenderMonster = getCurrentMonster();
        if(attackerMonster.attack(defenderMonster)){
            display.show(playerName + "의 " + getCurrentMonster().getName() + "가 당했다!");
            currentMonsterIdx++;
            if(currentMonsterIdx == monsterArrayList.size()) return true;
            display.show(getName() + ": 나와라! " + getCurrentMonster().getName() + "!");
        }
        else{

        }
        return false;
    }
    private Monster getCurrentMonster(){
        return monsterArrayList.get(currentMonsterIdx);
    }
}
