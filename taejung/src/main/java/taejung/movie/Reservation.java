package taejung.movie;

import taejung.money.Money;

public class Reservation {
    private Customer customer;
    private taejung.movie.Screening Screening;
    private Money fee;
    private int audienceCount;

    public Reservation(Customer customer, taejung.movie.Screening Screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.Screening = Screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
}
