package movie;

import money.Money;
import movie.pricing.*;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MovieTest {
    public static void main(String[] args) {
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                "3D Dolby",
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                    new SequenceCondition(1),
                    new SequenceCondition(10),
                    new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                    new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
                ));

        Movie titanic = new Movie("타이타닉",
                Duration.ofMinutes(180),
                "2D IMAX",
                Money.wons(11000),
                new PercentDiscountPolicy(0.1,
                        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16,59)),
                        new SequenceCondition(2),
                        new PeriodCondition(DayOfWeek.FRIDAY, LocalTime.of(13, 0), LocalTime.of(17, 59))
                ));

        Movie starWars = new Movie("스타워즈",
                Duration.ofMinutes(210),
                "2D SoundX",
                Money.wons(12000),
                new NoneDiscountPolicy());

        Screening firstMovie = new Screening(avatar, 1, LocalDateTime.of(2023, 8, 17, 10, 10),
                                    "메가박스 코엑스점", "Dolby 시네마");
        Customer gong = new Customer("공예슬", "ysgong");
        Reservation reservationGong = firstMovie.reserve(gong, 2);
        reservationGong.showReservationInfo();

        Screening secondMovie = new Screening(starWars, 2, LocalDateTime.of(2023, 8, 26, 23, 15),
                                    "CGV 여의도IFC몰", "지하1층 6관");
        Customer heo = new Customer("허태정", "htj");
        Reservation reservationHeo = secondMovie.reserve(heo, 4);
        reservationHeo.showReservationInfo();
        reservationHeo.cancelReservation();

        reservationGong.cancelReservation();



    }
}
