package org.eternity.movie.assignment3.pricing;

import org.eternity.movie.assignment3.DiscountCondition;
import org.eternity.movie.assignment3.Screening;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
