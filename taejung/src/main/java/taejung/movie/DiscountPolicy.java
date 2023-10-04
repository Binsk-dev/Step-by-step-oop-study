package taejung.movie;

import taejung.money.Money;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Money defaultMoney, Screening screening);
}
