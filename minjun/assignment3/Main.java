package org.eternity.movie.assignment3;

import org.eternity.money.Money;
import org.eternity.movie.assignment3.pricing.PercentDiscountPolicy;
import org.eternity.movie.assignment3.pricing.SequenceCondition;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Customer 하하 = new Customer("하하", "12345");
        Movie movie = new Movie("오펜하이머", Duration.parse("PT3H"), Money.wons(30000), Arrays.asList(new PercentDiscountPolicy(0.2, new SequenceCondition(1))), new Dimension2());
        Screening screening = new Screening(movie, 1, LocalDateTime.of(2024, 3, 2, 10, 30), "노원 CGV", "11열");
        Reservation reservation1 = screening.reserve(하하, new Member(2, 1, 1));

        movie = new Movie("바비", Duration.parse("PT2H"), Money.wons(20000), Arrays.asList(new PercentDiscountPolicy(0.2, new SequenceCondition(2))), new Dimension3());
        screening = new Screening(movie, 2, LocalDateTime.now(), "노원 CGV", "13열");
        Reservation reservation2 = screening.reserve(하하, new Member(1, 0, 1));

        하하.showAllReservation();

        System.out.println("-------------------------------------\n");
        하하.cancelReservation(reservation1.getUid());
        System.out.println("\n-------------------------------------");

        하하.showAllReservation();

        System.out.println("-------------------------------------\n");
        하하.cancelReservation(reservation2.getUid());
        System.out.println("\n-------------------------------------");

    }
}
