package taejung.movie;

import taejung.money.Money;

public interface RefundPolicy {
    Money calculateRefundAmount(Screening screening);
}
