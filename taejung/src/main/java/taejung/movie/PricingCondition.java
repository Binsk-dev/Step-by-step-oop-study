package taejung.movie;

public interface PricingCondition {
    boolean isSatisfied(Audience audience, Screening screening);
}
