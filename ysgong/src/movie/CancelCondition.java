package movie;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class CancelCondition {
    private DayOfWeek dayOfWeek;
    private LocalTime now;
    public CancelCondition(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        this.now = LocalTime.now();
    }
    public boolean isSatisfiedCanceled(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
                now.isBefore(screening.getStartTime().toLocalTime().minusHours(1));
    }
}
