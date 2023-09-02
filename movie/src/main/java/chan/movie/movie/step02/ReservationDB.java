package chan.movie.movie.step02;

import java.util.ArrayList;

public class ReservationDB extends ArrayList {
    private ArrayList arrayList;

    public ReservationDB(ArrayList reservationDB) {
        this.arrayList = reservationDB;
    }

    // 생각해보니까 insert랑 delete를 분리하는게 좋지않았을까..
    // 책임이 너무 커진 느낌인데...

    public void insert(Reservation reservation) {
        this.add(reservation);
    }

    public ArrayList check(String name, String id){
        ArrayList returnList = new ArrayList();
        for (int i = 0; i < this.size(); i++) {
            Reservation reservation = (Reservation) this.get(i);
            if (reservation.check(name, id)) {
                returnList.add(reservation);
            }
        }
        return returnList;
    }

    public void delete() {

    }
}
