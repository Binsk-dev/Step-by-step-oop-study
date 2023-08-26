package taejung.movie.pricing;

import taejung.money.Money;
import taejung.movie.DiscountPolicy;
import taejung.movie.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
