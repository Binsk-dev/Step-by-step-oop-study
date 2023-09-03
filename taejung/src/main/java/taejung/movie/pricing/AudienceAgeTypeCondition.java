package taejung.movie.pricing;

import taejung.movie.Audience;
import taejung.movie.AudienceAgeType;
import taejung.movie.PricingCondition;
import taejung.movie.Screening;

public class AudienceAgeTypeCondition implements PricingCondition {

    private final AudienceAgeType audienceAgeType;

    public AudienceAgeTypeCondition(AudienceAgeType audienceAgeType) {
        this.audienceAgeType = audienceAgeType;
    }

    @Override
    public boolean isSatisfied(Audience audience, Screening screening) {
        return audience.getAudienceAgeType() == audienceAgeType;
    }
}
