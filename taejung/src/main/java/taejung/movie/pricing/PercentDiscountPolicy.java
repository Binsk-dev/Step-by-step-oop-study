package taejung.movie.pricing;

import taejung.money.Money;
import taejung.movie.DefaultDiscountPolicy;
import taejung.movie.DiscountCondition;
import taejung.movie.Screening;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
