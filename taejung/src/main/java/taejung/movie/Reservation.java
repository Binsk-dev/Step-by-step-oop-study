package taejung.movie;

import taejung.money.Money;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Reservation {
    private UUID uuid;
    private Customer customer;
    private Screening screening;

    private Money fee;
    private List<Audience> audiences;
    private LocalDateTime whenReserved;

    public Reservation(UUID uuid, Customer customer, Screening Screening, Money fee, List<Audience> audiences, LocalDateTime whenReserved) {
        this.uuid = uuid;
        this.customer = customer;
        this.screening = Screening;
        this.fee = fee;
        this.audiences = audiences;
        this.whenReserved = whenReserved;
    }

    public Money getFee() {
        return fee;
    }

    public String getAudienceInformation() {
        StringBuilder audienceInformation = new StringBuilder();
        for (int i =0; i<audiences.size(); i++)
        {
            Audience audience = audiences.get(i);
            audienceInformation.append(audience.getAudienceInformation());
            if(i != audiences.size()-1) {
                audienceInformation.append(",");
            }
        }
        return audienceInformation.toString();
    }

    public void showReservationInformation() {
        System.out.println(
                "예매 아이디:"
                        + uuid
                        + "\n예매한 시각:"
                        + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(whenReserved)
                        + "\n예매 매수: "
                        + getAudienceInformation()
                        + "\n지불액: "
                        + fee
                        + screening.getScreeningInformation()
        );

    }

    public Money refund(){
        Money amount = Money.ZERO;
        for(Audience audience: audiences) {
            amount = amount.plus(screening.calculateRefundAmount(audience));
        }
        return amount;
    }
}
