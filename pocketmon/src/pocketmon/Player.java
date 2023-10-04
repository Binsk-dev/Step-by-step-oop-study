package pocketmon;

import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class Player {
    String name;
    int currentUnitIndex;
    private final List<Unit> unitList;

    public Player(String name, List<Unit> unitList) {
        this.name = name;
        this.currentUnitIndex = 0;
        this.unitList = unitList;
    }

    public String getName() {
        return name;
    }

    /**
     * 상대 Player를 공격하도록 가지고 있는 Unit에게 명령
     *
     * @param opponent 공격할 상대 Player
     */
    public void attack(Player opponent) {
        System.out.println(getName() + "이(가) " + opponent.getName() + "을(를) 공격!");
        Unit currentUnit = getCurrentUnit();
        if (currentUnit != null) {
            currentUnit.attack(opponent.getCurrentUnit());
        }
    }

    public int getRemainUnitCount() {
        return Math.max(unitList.size() - this.currentUnitIndex, 0);
    }

    /**
     * 현재 unit 이 있으면 반환하고 그렇지 않다면 다음 살아있는 unit 을 찾아 반환
     *
     * @return 살아있는 unit이 있을 경우 현재 unit 반환, 없다면 null 반환
     */
    @Nullable
    public Unit getCurrentUnit() {
        try {
            return unitList.get(currentUnitIndex);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void skipToNextUnit() {
        currentUnitIndex += 1;
    }

    /**
     * 현재 unit 이 살았는지 죽었는지 확인
     *
     * @return 살았으면 true, 아니면 false
     */
    public boolean isCurrentUnitAlive() {
        Unit currentUnit = this.getCurrentUnit();
        if (currentUnit == null) {
            System.out.println("전투에 참가할 unit이 없습니다.");
            return false;
        }

        if (!currentUnit.isAlive()) {
            System.out.println(getName() + " 의 " + getCurrentUnit().getName() + " 전투불능!!");
        }
        return currentUnit.isAlive();
    }

    public void showCurrentUnitStatus() {
        System.out.println("===== " + getName() + " 의 포켓몬 상태 " + "=====");
        Objects.requireNonNull(getCurrentUnit()).showStatus();
    }
}
