package chan.movie.movie.step02;


import chan.movie.money.Money;
import chan.movie.movie.step02.pricing.AmountDiscountPolicy;
import chan.movie.movie.step02.pricing.PeriodCondition;
import chan.movie.movie.step02.pricing.SequenceCondition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    public void beforeEach(){
        avatar = new Movie("avatar",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10,0), LocalTime.of(11,59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10,0), LocalTime.of(20,59))));

        screeningAvatar = new Screening(avatar, TWO_DIMENSION,120,
                LocalDateTime.of(2021, 1, 1, 0, 0, 0),
                "성신여대점", "11층 09관"
                );

        chan = new Customer("chan", "45694410");

        reservationDB = new ReservationDB(new ArrayList());

    }


    @Test
    void getStartTimeTest() {
    }

    @Test
    void isSequenceTest() {
    }

    @Test
    void getMovieFeeTest() {
    }

    @Test
    void reserveTest() {
        // given

        // when
        Reservation reservationAvatar = new Reservation(chan, screeningAvatar, screeningAvatar.getMovieFee(), 5, reservationDB);

        // then
        assertThat(reservationAvatar).isNotNull();

    }
}