package chan.movie.movie.step02;

import chan.movie.money.Money;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
