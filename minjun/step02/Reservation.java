package org.eternity.movie.step02;

import org.eternity.money.Money;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private int uid;
    private Customer customer;
    private org.eternity.movie.step02.Screening Screening;
    private Money fee;
    private LocalDateTime whenReservation;
    private member members;

    public Reservation(Customer customer, org.eternity.movie.step02.Screening Screening, Money fee, member members) {
        this.uid = (int)(Math.random() * 10000000);
        this.customer = customer;
        this.Screening = Screening;
        this.fee = fee;
        this.whenReservation = java.time.LocalDateTime.now();
        this.members = members;
        customer.storeReservation(this.uid, this);
    }
    public void showReservationInfo(){
        System.out.println("예매 UUID: " + uid);
        System.out.println("예매한 시간: " + whenReservation.format(DateTimeFormatter.ISO_LOCAL_DATE) + " " +  whenReservation.format(DateTimeFormatter.ISO_LOCAL_TIME));
        members.showMemberInfo();
        System.out.println("지불액: " + fee.toString());
        Screening.showScreeningInfo();
    }
    public Money calculateCancelFee(){
        if(Screening.canCanceled()){
            return fee.times(0.9);
        }
        else{
            return Money.ZERO;
        }
    }
    // 삭제 예시를 위한 getter

    public int getUid() {
        return uid;
    }
}
