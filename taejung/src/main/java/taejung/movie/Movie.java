package taejung.movie;

import taejung.money.Money;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;
    private RefundPolicy refundPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy, RefundPolicy refundPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
        this.refundPolicy = refundPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public Money calculateRefundAmount(Screening screening) {
        return refundPolicy.calculateRefundAmount(screening);
    }

    public Duration getRunningTime() {
        return this.runningTime;
    }

    public String getTitle() {
        return title;
    }
}

