package taejung.movie;

import taejung.money.Money;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;
    private ScreeningDimension dimension;
    private Theater theater;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened, ScreeningDimension dimension, Theater theater) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
        this.dimension = dimension;
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

    public String getScreeningInformation() {
        return "\n제목:" +
                movie.getTitle() +
                "\n상영 유형: " +
                dimension.toString() +
                "\n상영 시간: " +
                movie.getRunningTime().toMinutes() + "분" +
                "\n상영 날짜: " +
                new SimpleDateFormat("yyyy-MM-dd").format(getStartTime()) +
                "\n상영 시각: " +
                new SimpleDateFormat("HH:mm").format(getStartTime()) +
                "\n영화관: " +
                theater.getCinamaName() +
                "\n상영관: " +
                theater.getName();
    }

    public Reservation reserve(Customer customer, List<Audience> audiences) {
        Money fee = Money.ZERO;
        for(Audience audience : audiences) {
            fee = fee.plus(calculateFee(audience));
        }
        return new Reservation(UUID.randomUUID(), customer, this, fee, audiences, LocalDateTime.now());
    }

    private Money calculateFee(Audience audience) {
        return audience.calculateTotalAmount(movie.calculateMovieFee(this));
    }

    public Money calculateRefundAmount(Audience audience) {
        return audience.calculateTotalAmount(movie.calculateRefundAmount(this));
    }

}
