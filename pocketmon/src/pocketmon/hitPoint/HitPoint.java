package pocketmon.hitPoint;

import java.math.BigDecimal;
import java.util.Objects;

public class HitPoint {
    public static final HitPoint ZERO =  HitPoint.valueOf(0);

    BigDecimal value;

    public static HitPoint valueOf(double value) {
        return new HitPoint(BigDecimal.valueOf(value));
    }

    public HitPoint(BigDecimal value) {
        this.value = value;
    }

    public HitPoint plus(HitPoint amount) {
        return new HitPoint(this.value.add(amount.value));
    }

    public HitPoint minus(HitPoint amount) {
        return new HitPoint(this.value.subtract(amount.value));
    }

    public HitPoint times(double percent) {
        return new HitPoint(this.value.multiply(BigDecimal.valueOf(percent)));
    }

    public boolean isLessThan(HitPoint other) {
        return value.compareTo(other.value) < 0;
    }

    public boolean isGreaterThan(HitPoint other) {
        return value.compareTo(other.value) > 0;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final HitPoint damage = (HitPoint) o;
        return Objects.equals(this.value, damage.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }


    @Override
    public String toString() {
        return value.toString();
    }
}
