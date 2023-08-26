package chan.movie.movie.step02;

import chan.movie.money.Money;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Reservation {
    private Customer customer;
    private Screening Screening;
    private Money fee;
    private int audienceCount;
    private LocalDateTime reservedTime;
    private ReservationDB reservationDB;


    public Reservation(Customer customer, Screening Screening, Money fee, int audienceCount,LocalDateTime reservedTime, ReservationDB reservationDB) {
        this.customer = customer;
        this.Screening = Screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
        this.reservedTime = reservedTime;
        this.reservationDB = reservationDB;
        reservationDB.insert(this);
    }

    // overloading
    public Reservation(Customer customer, Screening Screening, Money fee, int audienceCount, ReservationDB reservationDB) {
        this.customer = customer;
        this.Screening = Screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
        this.reservedTime = LocalDateTime.now();
        this.reservationDB = reservationDB;
        reservationDB.insert(this);
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getReservedTime() {
        return this.reservedTime;
    }

    public boolean check(String name, String id) {
        if (customer.CheckName(name) && customer.CheckId(id)) {
            return true;
        } else return false;
    }
}
