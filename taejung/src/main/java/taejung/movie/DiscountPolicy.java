package taejung.movie;

import taejung.money.Money;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
