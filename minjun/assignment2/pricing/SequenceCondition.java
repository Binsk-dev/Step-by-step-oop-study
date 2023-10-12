package org.eternity.movie.assignment2.pricing;

import org.eternity.movie.assignment2.DiscountCondition;
import org.eternity.movie.assignment2.Screening;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
