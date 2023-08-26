package movie;

import money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CancelPolicy {
    private List<CancelCondition> conditions = new ArrayList<>();
    private double percent;

    public CancelPolicy(CancelCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
        this.percent = 0.9;
    }

    public Money calculateRefundAmount(Screening screening, Money fee) {
        for(CancelCondition each : conditions) {
            if (each.isSatisfiedCanceled(screening)) {
                return getDiscountAmount(fee);
            }
        }

        return Money.ZERO;
    }

    protected Money getDiscountAmount(Money fee) {
        return fee.times(percent);
    }
}
