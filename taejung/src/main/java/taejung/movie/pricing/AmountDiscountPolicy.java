package taejung.movie.pricing;

import taejung.money.Money;
import taejung.movie.DefaultDiscountPolicy;
import taejung.movie.DiscountCondition;
import taejung.movie.Screening;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
