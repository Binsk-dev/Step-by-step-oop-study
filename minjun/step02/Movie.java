package org.eternity.movie.step02;

import org.eternity.money.Money;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;
    private int dimension;
    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy, int dimension) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
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
        System.out.println("상영 유형: " + dimension + "D");
        System.out.println("상영 시간: " + runningTime.getSeconds() / 60 + "분");
    }
}

