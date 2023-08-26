package chan.movie.movie.step02.pricing;

import chan.movie.money.Money;
import chan.movie.movie.step02.DefaultDiscountPolicy;
import chan.movie.movie.step02.DiscountCondition;
import chan.movie.movie.step02.Screening;

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
