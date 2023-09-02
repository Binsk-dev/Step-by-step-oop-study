package org.eternity.movie.assignment3;

import org.assertj.core.api.Assertions;
import org.eternity.money.Money;
import org.eternity.movie.assignment3.pricing.PercentDiscountPolicy;
import org.eternity.movie.assignment3.pricing.SequenceCondition;
import org.junit.jupiter.api.Test;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;



class ScreeningTest {
    @Test
    public void 지불액(){
        Customer 하하 = new Customer("하하", "12345");
        Movie movie = new Movie("오펜하이머", Duration.parse("PT3H"), Money.wons(30000), Arrays.asList(new PercentDiscountPolicy(0.2, new SequenceCondition(1))), new Dimension2());
        Screening screening = new Screening(movie, 1, LocalDateTime.of(2024, 3, 2, 10, 30), "노원 CGV", "11열");
        Reservation reservation1 = screening.reserve(하하, new Member(2, 1, 1));

        movie = new Movie("바비", Duration.parse("PT2H"), Money.wons(20000), Arrays.asList(new PercentDiscountPolicy(0.2, new SequenceCondition(2))), new Dimension3());
        screening = new Screening(movie, 2, LocalDateTime.now(), "노원 CGV", "13열");
        Reservation reservation2 = screening.reserve(하하, new Member(1, 0, 1));

        Assertions.assertThat(reservation1.getFee().toString()).isEqualTo("88800.000원");
    }
    @Test
    public void 환불가능(){
        Customer 하하 = new Customer("하하", "12345");
        Movie movie = new Movie("오펜하이머", Duration.parse("PT3H"), Money.wons(30000), Arrays.asList(new PercentDiscountPolicy(0.2, new SequenceCondition(1))), new Dimension2());
        Screening screening = new Screening(movie, 1, LocalDateTime.of(2024, 3, 2, 10, 30), "노원 CGV", "11열");
        Reservation reservation1 = screening.reserve(하하, new Member(2, 1, 1));

        movie = new Movie("바비", Duration.parse("PT2H"), Money.wons(20000), Arrays.asList(new PercentDiscountPolicy(0.2, new SequenceCondition(2))), new Dimension3());
        screening = new Screening(movie, 2, LocalDateTime.now(), "노원 CGV", "13열");
        Reservation reservation2 = screening.reserve(하하, new Member(1, 0, 1));

        Assertions.assertThat(하하.cancelReservation(reservation1.getUid()).toString()).isEqualTo("79920.0000원");

    }
    @Test
    public void 환불불가(){
        Customer 하하 = new Customer("하하", "12345");
        Movie movie = new Movie("오펜하이머", Duration.parse("PT3H"), Money.wons(30000), Arrays.asList(new PercentDiscountPolicy(0.2, new SequenceCondition(1))), new Dimension2());
        Screening screening = new Screening(movie, 1, LocalDateTime.of(2024, 3, 2, 10, 30), "노원 CGV", "11열");
        Reservation reservation1 = screening.reserve(하하, new Member(2, 1, 1));

        movie = new Movie("바비", Duration.parse("PT2H"), Money.wons(20000), Arrays.asList(new PercentDiscountPolicy(0.2, new SequenceCondition(2))), new Dimension3());
        screening = new Screening(movie, 2, LocalDateTime.now(), "노원 CGV", "13열");
        Reservation reservation2 = screening.reserve(하하, new Member(1, 0, 1));
        Assertions.assertThat(하하.cancelReservation(reservation2.getUid()).toString()).isEqualTo("0원");
    }
}