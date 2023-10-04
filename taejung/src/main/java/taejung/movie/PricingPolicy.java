package taejung.movie;

import taejung.money.Money;

public interface PricingPolicy {
    public Money calculatePriceChangeAmount(Audience audience, Screening screening);
}
