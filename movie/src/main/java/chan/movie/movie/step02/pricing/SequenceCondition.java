package chan.movie.movie.step02.pricing;

import chan.movie.movie.step02.DiscountCondition;
import chan.movie.movie.step02.Screening;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
