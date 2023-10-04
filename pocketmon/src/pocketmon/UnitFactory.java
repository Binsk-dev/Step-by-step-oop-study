package pocketmon;

import pocketmon.damage.Armour;
import pocketmon.damage.Attack;
import pocketmon.damage.AttackType;
import pocketmon.hitPoint.HitPoint;

import java.util.*;

public class UnitFactory {
    Random random;

    UnitFactory() {
        random = new Random();
    }

    public Unit createRandomUnit(String namePrefix) {
        List<AttackType> attackTypeList = new ArrayList<>(Arrays.asList(AttackType.values()));

        List<Attack> attackList = new ArrayList<>();
        for (int i = 0; i < random.nextInt(1, 5); i++) {
            Collections.shuffle(attackTypeList);
            attackList.add(Attack.valueOf(random.nextInt(50, 200), attackTypeList.get(0)));
        }
        List<Armour> armourList = new ArrayList<>();
        for (int i = 0; i < random.nextInt(1, 5); i++) {
            Collections.shuffle(attackTypeList);
            armourList.add(
                    Armour.valueOf(
                            random.nextInt(50, 200),
                            attackTypeList.get(0),
                            Math.round(random.nextDouble() * 100.0) / 100.0
                    )
            );
        }

        return new Unit(
                HitPoint.valueOf(new Random().nextInt(300, 1000)),
                "포켓몬 " + namePrefix,
                attackList,
                armourList
        );
    }

    public List<Unit> createRandomUnitList(String namePrefix, int min, int max) {
        List<Unit> unitList = new ArrayList<>();
        for (int i = 0; i < random.nextInt(min, max); i++) {
            unitList.add(createRandomUnit(namePrefix + i));
        }
        return unitList;
    }
}
