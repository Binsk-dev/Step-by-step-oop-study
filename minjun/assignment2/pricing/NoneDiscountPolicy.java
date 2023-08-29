package org.eternity.movie.assignment2.pricing;

import org.eternity.money.Money;
import org.eternity.movie.assignment2.DiscountPolicy;
import org.eternity.movie.assignment2.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
