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
    private List<Audience> audienceTypes;
    private LocalDateTime whenReserved;

    public Reservation(UUID uuid, Customer customer, Screening Screening, Money fee, List<Audience> audienceTypes, LocalDateTime whenReserved) {
        this.uuid = uuid;
        this.customer = customer;
        this.screening = Screening;
        this.fee = fee;
        this.audienceTypes = audienceTypes;
        this.whenReserved = whenReserved;
    }

    public String getAudienceInformation() {
        StringBuilder audienceInformation = new StringBuilder();
        for (Audience audienceType : audienceTypes) {
            audienceInformation.append(audienceType.getAudienceType());
            audienceInformation.append(" ");
            audienceInformation.append(audienceType.getAudienceCount());
            audienceInformation.append("명 ");
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
        for(Audience audience: audienceTypes) {
            amount = amount.plus(screening.calculateRefundAmount(audience));
        }
        return amount;
    }
}
