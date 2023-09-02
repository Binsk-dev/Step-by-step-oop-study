package chan.movie.movie.step02;

import chan.movie.money.Money;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private Member member;
    private MovieCategory category;
    private int sequence;
    private LocalDateTime whenScreened;
    private String cinema; // 영화관
    private String theater; // 상영관
    private ReservationDB reservationDB;

    public Screening(Movie movie, Member member, MovieCategory category, int sequence, LocalDateTime whenScreened, String cinema, String theater) {
        this.movie = movie;
        this.member = member;
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

    // Movie에 있는 getFee는 Screening에서 그 책임을 받는게 나아 보여.
    // 왜냐면 "영화관"마다, 인간 유형마다 다 금액이 다르니까.
    public Money getMovieFee() {
        return Money.wons(category.movieCharge);
    }

    // Customer 랑 Member 를 합칠 수 있지 않을까... 코드가 너무 개판이 되어 가는거 같은데......
    public Reservation reserve(Customer customer, Member member) {
            return new Reservation(customer, this, calculateFee(),
                reservationDB);
    }

    public Money calculateFee() {
        Member member = this.member;

        Money result = Money.wons(0);
        // 성인요금 = (영화 표값 - 어른 할인 값) * 어른 수
        result.plus(getMovieFee().minus(Money.wons(member.getAdultDiscount())).times(member.getAdult()));
        // 청소년 요금 = (영화 표값 - 청소년 할인 값) * 청소년 수
        result.plus(getMovieFee().minus(Money.wons(member.getTeenDiscount())).times(member.getTeen()));
        // 아동 요금 = (영화 표값 - 아동 할인 값) * 아이 수
        result.plus(getMovieFee().minus(Money.wons(member.getChildDiscount())).times(member.getChild()));
        return result;
    }

    public int totalMember() {
        return member.totalMember();
    }
}
