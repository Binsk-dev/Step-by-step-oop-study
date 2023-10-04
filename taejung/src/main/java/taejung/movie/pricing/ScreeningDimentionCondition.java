package taejung.movie.pricing;

import taejung.movie.*;

public class ScreeningDimentionCondition implements PricingCondition {

    private final ScreeningDimension screeningDimension;

    public ScreeningDimentionCondition(ScreeningDimension screeningDimension) {
        this.screeningDimension = screeningDimension;
    }

    @Override
    public boolean isSatisfied(Audience audience, Screening screening) {
        return screening.getScreeningDimension() == screeningDimension;
    }
}
