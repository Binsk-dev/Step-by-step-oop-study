package taejung.movie;

import taejung.money.Money;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private final String title;
    private final Duration runningTime;
    private final Money fee;
    private final List<PricingPolicy> pricingPolicies;
    private final DiscountPolicy discountPolicy;
    private final RefundPolicy refundPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy, RefundPolicy refundPolicy, PricingPolicy... pricingPolicies) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.pricingPolicies = Arrays.asList(pricingPolicies);
        this.discountPolicy = discountPolicy;
        this.refundPolicy = refundPolicy;
    }

    public Money getMovieFee(Audience audience, Screening screening) {
        Money money = fee;
        for (PricingPolicy pricingPolicy : pricingPolicies) {
            money = money.plus(pricingPolicy.calculatePriceChangeAmount(audience, screening));
        }
        return money;
    }

    public Money calculateMovieFee(Money defaultFee, Screening screening) {
        return defaultFee.minus(discountPolicy.calculateDiscountAmount(defaultFee, screening));
    }

    public Money calculateRefundAmount(Money defaultFee, Screening screening) {
        return refundPolicy.calculateRefundAmount(defaultFee, screening);
    }

    public Duration getRunningTime() {
        return this.runningTime;
    }

    public String getTitle() {
        return title;
    }
}

