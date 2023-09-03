package taejung.movie.pricing;

import taejung.money.Money;
import taejung.movie.DefaultPricingPolicy;
import taejung.movie.PricingCondition;
import taejung.movie.Screening;

public class AmountPricingPolicy extends DefaultPricingPolicy {
    private final Money amount;


    public AmountPricingPolicy(Money amount, PricingCondition... conditions) {
        super(conditions);
        this.amount = amount;
    }

    @Override
    protected Money getPriceChangeAmount(Screening screening) {
        return amount;
    }
}
