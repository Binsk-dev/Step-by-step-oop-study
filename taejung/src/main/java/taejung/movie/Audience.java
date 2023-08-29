package taejung.movie;

import taejung.money.Money;


public class Audience {

    private AudienceType audienceType;
    private int audienceCount;

    public Audience(AudienceType audienceType, Money fee, int audienceCount) {
        this.audienceType = audienceType;
        this.audienceCount = audienceCount;
    }

    public Money calculateTotalAmount(Money money) {
        return money.times(audienceCount);
    }

    public String getAudienceInformation() {
        return audienceType + " " + audienceCount + "명";
    }
}
