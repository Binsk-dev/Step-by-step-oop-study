package chan.movie.movie.step02;

import chan.movie.money.Money;
import chan.movie.movie.step02.pricing.AmountDiscountPolicy;
import chan.movie.movie.step02.pricing.PeriodCondition;
import chan.movie.movie.step02.pricing.SequenceCondition;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import static chan.movie.movie.step02.MovieCategory.TWO_DIMENSION;
import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {
    ReservationDB reservationDB;
    Movie avatar;
    Screening screeningAvatar;
    Customer chan;
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
        screeningAvatar = new Screening(avatar, member, TWO_DIMENSION, 120,
                LocalDateTime.of(2021, 1, 1, 0, 0, 0),
                "성신여대점", "11층 09관"
        );
        chan = new Customer("chan", "45694410");

        reservationDB = new ReservationDB(new ArrayList());
    }

    @Test
    @DisplayName("시간 입력이 따로 없는 경우 현재 시간으로 압력")
    void initializingTest(){
        // given

        // when
        Reservation reservationAvatar1 = new Reservation(chan, screeningAvatar, screeningAvatar.getMovieFee(), reservationDB);

        // then
//        디버그로 reservation 확인했음....
//        System.out.println("reservationAvatar1 = " + reservationAvatar1);
    }
    @Test
    @DisplayName("(디버그용) 시간 입력을 따로 하면 그 시간으로 예약시간을 넣어줌. ")
    void initializingTest2(){
        // given
        LocalDateTime resDateTime = LocalDateTime.parse("2023-08-26T23:50:45.619");
        // when
        Reservation reservationAvatar1 = new Reservation(chan, screeningAvatar, screeningAvatar.getMovieFee(), resDateTime , reservationDB);

        // then
//        디버그로 reservation 확인했음....
//        System.out.println("reservationAvatar1 = " + reservationAvatar1);
    }

    @Test
    @DisplayName("체크 테스트")
    // DB에 접근해서 customer 의 id, name 같은 reservation 반환
    void checkTest() {
        // given
        Reservation reservationAvatar1 = new Reservation(chan, screeningAvatar, screeningAvatar.getMovieFee(), reservationDB);
        // when
        boolean ret = reservationAvatar1.check("chan", "45694410");
        // then
        Assertions.assertThat(ret).isTrue();
    }

    @Test
    @DisplayName("체크 테스트")
    // DB에 접근해서 customer 의 id, name 같은 reservation 반환
    void checkTestFail() {
        // given
        Reservation reservationAvatar1 = new Reservation(chan, screeningAvatar, screeningAvatar.getMovieFee(), reservationDB);

        // when
        boolean ret = reservationAvatar1.check("Not chan", "12345678");
        // then
        Assertions.assertThat(ret).isFalse();
    }




}