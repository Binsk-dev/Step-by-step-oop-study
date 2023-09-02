package org.eternity.movie.assignment3;

import org.eternity.money.Money;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
