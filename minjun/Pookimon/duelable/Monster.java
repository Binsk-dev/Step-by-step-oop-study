package Pookimon.duelable;

import Pookimon.display.Display;
import Pookimon.type.Type;

public class Monster implements Duelable{
    private String name;
    private int power;
    private int fullHP;
    private int remainHP;
    private Type type;
    private Display display;
    public Monster(String name, int power, int fullHP, Type type, Display display) {
        this.name = name;
        this.power = power;
        this.fullHP = fullHP;
        this.type = type;
        this.display = display;
    }
    @Override
    public String getName() {
        return name + "(푸키몬)";
    }

    @Override
    public boolean attack(Duelable defender) {
        return defender.attacked(this);
    }

    @Override
    public boolean attacked(Monster attacker) {
        int power = type.calculatePower(attacker.power, attacker.type);
        display.show("데미지 " + power + "가 들어갔습니다!");
        remainHP -= power;
        display.show("공격받은 푸키몬 \n" + getStatus());
        return (remainHP <= 0);
    }

    @Override
    public void init() {
        remainHP = fullHP;
    }

    public String getStatus(){
        return "이름: " + getName() + "\n" +
                "파워: " + power + "\n" +
                "HP: " + remainHP + "|" + fullHP + "\n" +
                "타입: " + type.getTypeName() + "\n";
    }
}
