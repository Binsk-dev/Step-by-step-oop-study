package taejung.movie;

import taejung.money.Money;


public class Audience {
    private AudienceAgeType audienceAgeType;
    private int audienceCount;

    public Audience(AudienceAgeType audienceAgeType, int audienceCount) {
        this.audienceAgeType = audienceAgeType;
        this.audienceCount = audienceCount;
    }

    public AudienceAgeType getAudienceAgeType() {
        return audienceAgeType;
    }

    public Money calculateTotalAmount(Money money) {
        return money.times(audienceCount);
    }

    public String getAudienceInformation() {
        return audienceAgeType + " " + audienceCount + "명";
    }
}
