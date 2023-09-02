package org.eternity.movie.assignment3.pricing;

import org.eternity.money.Money;
import org.eternity.movie.assignment3.DiscountPolicy;
import org.eternity.movie.assignment3.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
