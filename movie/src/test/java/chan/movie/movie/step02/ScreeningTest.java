package chan.movie.movie.step02;


import chan.movie.money.Money;
import chan.movie.movie.step02.pricing.AmountDiscountPolicy;
import chan.movie.movie.step02.pricing.PeriodCondition;
import chan.movie.movie.step02.pricing.SequenceCondition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import static chan.movie.movie.step02.MovieCategory.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ScreeningTest {

    Movie avatar;
    Screening screeningAvatar;
    Customer chan;
    ReservationDB reservationDB;
    Member member;

    @BeforeEach
    public void beforeEach(){
        avatar = new Movie("avatar",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10,0), LocalTime.of(11,59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10,0), LocalTime.of(20,59))),
                TWO_DIMENSION);

        member = new Member(1, 1, 1);
        screeningAvatar = new Screening(avatar, member, TWO_DIMENSION,120,
                LocalDateTime.of(2021, 1, 1, 0, 0, 0),
                "성신여대점", "11층 09관"
                );

        chan = new Customer("chan", "45694410");

        reservationDB = new ReservationDB(new ArrayList());

    }

    @Test
    @DisplayName("2D 성인 1인일 때 가격 15000원인지?")
    void getMovieFeeTest() {
        // given
        // beforeEach condition

        // when
        Member member1 = new Member(1, 0, 0);
        Screening screeningAvatar1 = new Screening(avatar, member1, TWO_DIMENSION,120,
                LocalDateTime.of(2021, 1, 1, 0, 0, 0),
                "성신여대점", "11층 09관"
        );
        Money ans = Money.wons(15000);
        Money expect = screeningAvatar1.calculateFee();
        // then

        assertThat(expect).isEqualTo(ans);
    }

    @Test
    void reserveTest() {
        // given

        // when
        Reservation reservationAvatar = new Reservation(chan, screeningAvatar, screeningAvatar.getMovieFee(), reservationDB);

        // then
        assertThat(reservationAvatar).isNotNull();

    }
}