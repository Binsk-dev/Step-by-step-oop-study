package org.eternity.movie.assignment2.pricing;

import org.eternity.money.Money;
import org.eternity.movie.assignment2.DefaultDiscountPolicy;
import org.eternity.movie.assignment2.DiscountCondition;
import org.eternity.movie.assignment2.Screening;

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
