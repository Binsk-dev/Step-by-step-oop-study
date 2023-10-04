package taejung.movie.refunding;

import taejung.money.Money;
import taejung.movie.*;

public class PercentRefundPolicy extends DefaultRefundPolicy {
    private final double percent;

    public PercentRefundPolicy(double percent, RefundCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getRefundAmount(Money defaultFee, Screening screening) {
        return screening.calculateMovieFee(defaultFee).times(percent);
    }
}
