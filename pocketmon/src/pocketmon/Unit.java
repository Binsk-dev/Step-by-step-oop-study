package pocketmon;

import pocketmon.damage.Armour;
import pocketmon.damage.Attack;
import pocketmon.damage.AttackType;
import pocketmon.hitPoint.HitPoint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Unit implements Attacker, Defencer {
    HitPoint hp;
    String name;
    Map<AttackType, Attack> attackTypeAttackMap;
    Map<AttackType, Armour> attackTypeArmourMap;

    public Unit(HitPoint hp, String name, List<Attack> attackList, List<Armour> armourList) {
        this.hp = hp;
        this.name = name;
        this.attackTypeAttackMap = new HashMap<>();
        this.attackTypeArmourMap = new HashMap<>();

        // 공격 타입을 기준으로 그룹화
        for (Attack attack : attackList) {
            attackTypeAttackMap.compute(attack.getAttackType(), (k, v) -> (v != null) ? v.plus(attack) : attack);
        }
        for (Armour armour : armourList) {
            attackTypeArmourMap.compute(armour.getAttackType(), (k, v) -> (v != null) ? v.plus(armour) : armour);
        }
    }

    public String getName() {
        return name + "(HP:" + hp + ")";
    }

    boolean isAlive() {
        return this.hp.isGreaterThan(HitPoint.ZERO);
    }

    public void attack(Unit opponent) {
        System.out.println(getName() + " 이(가) " + opponent.getName() + " 을(를) 공격!!");
        opponent.defence(this);
    }

    public void defence(Unit opponent) {
        for (Map.Entry<AttackType, Attack> entry : opponent.attackTypeAttackMap.entrySet()) {
            Armour armour = attackTypeArmourMap.get(entry.getKey());

            Attack attack = entry.getValue();
            System.out.println(getName() + " 이(가) " + opponent.getName() + " 의 " + entry.getValue() + " 공격을 받았다!");
            if (armour != null) {
                // 해당 공격에 대한 방어력이 있는 경우 방어
                System.out.println(armour.getEfficiency() * 100 + "%" + " 만큼의 " + entry.getKey() + " 공격을 방어!");
                attack = attack.times(1 - armour.getEfficiency());
            }
            takeDamage(attack);
        }
    }

    private void takeDamage(Attack attack) {
        System.out.println(getName() + "이 총 " + attack.toHitPoint() + " 만큼의 " + attack.getAttackType() + " 피해를 받았다!");
        this.hp = this.hp.minus(attack.toHitPoint());
    }

    public void showStatus() {
        System.out.println("===== " + name + " 의 상태창 =====");
        System.out.println("HP:" + hp);
        for (Attack attack : attackTypeAttackMap.values()) {
            System.out.println("ATK:" + attack);
        }
        for (Armour armour : attackTypeArmourMap.values()) {
            System.out.println("DEF:" + armour);
        }
    }
}
