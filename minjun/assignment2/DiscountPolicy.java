package org.eternity.movie.assignment2;

import org.eternity.money.Money;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
