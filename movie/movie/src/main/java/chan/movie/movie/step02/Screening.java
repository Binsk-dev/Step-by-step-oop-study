package chan.movie.movie.step02;

import chan.movie.money.Money;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private MovieCategory category;
    private int sequence;
    private LocalDateTime whenScreened;
    private String cinema; // 영화관
    private String theater; // 상영관
    private ReservationDB reservationDB;

    public Screening(Movie movie, MovieCategory category, int sequence, LocalDateTime whenScreened, String cinema, String theater) {
        this.movie = movie;
        this.category = category;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
        this.cinema = cinema;
        this.theater = theater;
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

    public Reservation reserve(Customer customer, int audienceCount) {
            return new Reservation(customer, this, calculateFee(audienceCount),
                audienceCount,reservationDB);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
