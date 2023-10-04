package taejung.movie;

import taejung.money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultPricingPolicy implements PricingPolicy {
    private List<PricingCondition> conditions = new ArrayList<>();

    public DefaultPricingPolicy(PricingCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public Money calculatePriceChangeAmount(Audience audience, Screening screening) {
        Money money = Money.ZERO;
        for(PricingCondition each : conditions) {
            if (each.isSatisfied(audience, screening)) {
                money = money.plus(getPriceChangeAmount(screening));
            }
        }
        return money;
    }

    abstract protected Money getPriceChangeAmount(Screening screening);
}
