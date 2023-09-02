package chan.movie.movie.step02.pricing;


import chan.movie.money.Money;
import chan.movie.movie.step02.DefaultDiscountPolicy;
import chan.movie.movie.step02.DiscountCondition;
import chan.movie.movie.step02.Screening;

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
