package chan.movie.movie.step02;


import chan.movie.money.Money;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;
    private MovieCategory movieCategory;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy,MovieCategory movieCategory) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
        this.movieCategory = movieCategory;
    }
    // getFee 는 Movie 보다 Screening에 있는게 더 합리적인거같아.
//     왜냐면 Screening 마다 금액이 다 다르니까 굳이 Movie에서 받을 이유가 없어보임.
    public Money getFee() {
        return fee;
    }

    public Money calculateTotalMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}

