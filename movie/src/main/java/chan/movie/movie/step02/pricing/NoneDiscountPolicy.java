package chan.movie.movie.step02.pricing;

import chan.movie.money.Money;
import chan.movie.movie.step02.DiscountPolicy;
import chan.movie.movie.step02.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
