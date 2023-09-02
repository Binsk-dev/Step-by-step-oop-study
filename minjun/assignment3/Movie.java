package org.eternity.movie.assignment3;

import org.eternity.money.Money;

import java.time.Duration;
import java.util.List;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountPolicy> discountPolicys;
    private Dimension dimension;
    public Movie(String title, Duration runningTime, Money fee, List<DiscountPolicy> discountPolicy, Dimension dimension) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = dimension.calculateDimensionFee(fee);
        this.discountPolicys = discountPolicy;
        this.dimension = dimension;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        Money money = Money.wons(0);
        for(DiscountPolicy discountPolicy : discountPolicys){
            Money tmp = discountPolicy.calculateDiscountAmount(screening);
            money = money.plus(tmp);
        }
        return fee.minus(money);
    }
    public void showMovieInfo(){
        System.out.println("제목: " + title);
        dimension.showDimensionInfo();
        System.out.println("상영 시간: " + runningTime.getSeconds() / 60 + "분");
    }
}

