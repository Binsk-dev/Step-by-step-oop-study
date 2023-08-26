package movie;

import money.Money;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;
    private String type;

    public Movie(String title, Duration runningTime, String type, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
        this.type = type;
    }

    public Money getFee() {
        return fee;
    }


    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public void showMovieInfo(){
        System.out.println("영화 제목: "+this.title);
        System.out.println("상영 유형: "+this.type);
        System.out.println("상영 시간: "+this.runningTime);
    }

}
