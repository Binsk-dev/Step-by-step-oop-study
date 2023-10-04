package pocketmon.damage;

import pocketmon.AttackType;
import pocketmon.hitPoint.HitPoint;

import java.math.BigDecimal;
import java.util.Objects;

public class Attack {
    private BigDecimal value;

    private AttackType attackType;

    public HitPoint toHitPoint() {
        return HitPoint.valueOf(Math.round(value.doubleValue() * 10) / 10.0);
    }

    public BigDecimal getValue() {
        return value;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public Attack(BigDecimal value, AttackType attackType) {
        this.value = value;
        this.attackType = attackType;
    }

    public static Attack valueOf(long value, AttackType attackType) {
        return new Attack(BigDecimal.valueOf(value), attackType);
    }

    public static Attack valueOf(double value, AttackType attackType) {
        return new Attack(BigDecimal.valueOf(value), attackType);
    }

    public Attack plus(Attack attack) {
        return new Attack(this.value.add(attack.value), attack.attackType);
    }

    public Attack minus(Attack attack) {
        return new Attack(this.value.subtract(attack.value), attack.attackType);
    }

    public Attack times(double percent) {
        return new Attack(this.value.multiply(BigDecimal.valueOf(percent)), this.attackType);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Attack attack = (Attack) o;
        return Objects.equals(this.value, attack.value) && this.attackType == attack.attackType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @Override
    public String toString() {
        return attackType.name() + ":" + value;
    }
}
