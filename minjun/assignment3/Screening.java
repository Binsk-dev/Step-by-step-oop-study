package org.eternity.movie.assignment3;

import org.eternity.money.Money;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;
    private String theater;
    private String place;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened, String theater, String place) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
        this.theater = theater;
        this.place = place;
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

    public Reservation reserve(Customer customer, Member members) {
        return new Reservation(customer, this, members.calculateTotalFee(movie.calculateMovieFee(this)),
                members);
    }

    public void showScreeningInfo(){
        movie.showMovieInfo();
        System.out.println("상영 날짜: " + whenScreened.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println("상영 시각: " + whenScreened.getHour() + ":" + whenScreened.getMinute());
        System.out.println("영화관: " + theater);
        System.out.println("상영관: " + place);
    }
    public boolean canCanceled(){
        if(whenScreened.minusHours(1).isAfter(LocalDateTime.now())){
            return true;
        }
        return false;
    }
}
