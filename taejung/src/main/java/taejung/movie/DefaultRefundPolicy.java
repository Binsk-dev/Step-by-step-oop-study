package taejung.movie;

import taejung.money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultRefundPolicy implements RefundPolicy {
    private List<RefundCondition> conditions = new ArrayList<>();

    public DefaultRefundPolicy(RefundCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    @Override
    public Money calculateRefundAmount(Screening screening) {
        for(RefundCondition each : conditions) {
            if (each.isRefundable(screening)) {
                return getRefundAmount(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getRefundAmount(Screening Screening);
}
