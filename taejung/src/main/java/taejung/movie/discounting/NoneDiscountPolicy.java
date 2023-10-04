package taejung.movie.discounting;

import taejung.money.Money;
import taejung.movie.DiscountPolicy;
import taejung.movie.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Money defaultMoney, Screening screening) {
        return Money.ZERO;
    }
}
