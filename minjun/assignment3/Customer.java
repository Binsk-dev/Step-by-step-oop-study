package org.eternity.movie.assignment3;

import org.eternity.money.Money;

import java.util.HashMap;

public class Customer {
	private String name;
	private String id;
	private HashMap<Integer, Reservation> reservations;
	public Customer(String name, String id) {
		this.id = id;
		this.name = name;
		this.reservations = new HashMap<>();
	}
	public void storeReservation(int uid, Reservation reservation){
		reservations.put(uid, reservation);
	}
	public void showAllReservation(){
		for(Reservation reservation : reservations.values()){
			System.out.println("----------------------------------");
			reservation.showReservationInfo();
		}
	}
	public String cancelReservation(int uid){
		Reservation reservation = reservations.remove(uid);
		Money cancelMoney = reservation.calculateCancelFee();
		System.out.println("환불 된 금액: " + cancelMoney.toString());
		return cancelMoney.toString();
	}
}
