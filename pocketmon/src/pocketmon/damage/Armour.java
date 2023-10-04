package pocketmon.damage;

import java.math.BigDecimal;
import java.util.Objects;

public class Armour {
    private BigDecimal value;
    private AttackType attackType;
    private double efficiency;

    public BigDecimal getValue() {
        return value;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public Armour(BigDecimal value, AttackType attackType) {
        this(value, attackType, 1.0);
    }


    public Armour(BigDecimal value, AttackType attackType, double efficiency) {
        this.value = value;
        this.attackType = attackType;
        this.efficiency = efficiency;
        assert (this.efficiency > 0 && this.efficiency <= 1);
    }

    public static Armour valueOf(double value, AttackType attackType) {
        return valueOf(value, attackType, 1.0);
    }

    public static Armour valueOf(double value, AttackType attackType, double efficiency) {
        return new Armour(BigDecimal.valueOf(value), attackType, efficiency);
    }

    public Armour plus(Armour armour) {
        return new Armour(this.value.add(armour.value), armour.attackType);
    }

    public Armour minus(Armour armour) {
        return new Armour(this.value.subtract(armour.value), armour.attackType);
    }

    public Armour times(double percent) {
        return new Armour(this.value.multiply(BigDecimal.valueOf(percent)), this.attackType);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Armour armour = (Armour) o;
        return Objects.equals(this.value, armour.value) && this.attackType == armour.attackType;
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
