package taejung.movie;

import taejung.money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {
    private List<DiscountCondition> conditions;

    public DefaultDiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public Money calculateDiscountAmount(Money defaultMoney, Screening screening) {
        for(DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(defaultMoney, screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Money defaultMoney, Screening Screening);
}
