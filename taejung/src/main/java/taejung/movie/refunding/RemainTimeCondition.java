package taejung.movie.refunding;

import taejung.movie.DiscountCondition;
import taejung.movie.RefundCondition;
import taejung.movie.Screening;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class RemainTimeCondition implements RefundCondition {
    private final Duration refundableTimeWindow;

    public RemainTimeCondition(Duration refundableTimeWindow){
        this.refundableTimeWindow = refundableTimeWindow;
    }

    public boolean isRefundable(Screening screening) {
        final LocalDateTime now = LocalDateTime.now();
        final LocalDateTime refundableTime = screening.getStartTime().minus(refundableTimeWindow);
        return refundableTime.isAfter(now);
    }
}
