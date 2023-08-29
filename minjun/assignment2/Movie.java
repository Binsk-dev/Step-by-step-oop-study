package org.eternity.movie.assignment2;

import org.eternity.money.Money;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;
    private Dimension dimension;
    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy, Dimension dimension) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = dimension.calculateDimensionFee(fee);
        this.discountPolicy = discountPolicy;
        this.dimension = dimension;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
    public void showMovieInfo(){
        System.out.println("제목: " + title);
        dimension.showDimensionInfo();
        System.out.println("상영 시간: " + runningTime.getSeconds() / 60 + "분");
    }
}

