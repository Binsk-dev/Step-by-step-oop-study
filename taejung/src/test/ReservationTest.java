import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import taejung.money.Money;
import taejung.movie.*;
import taejung.movie.discounting.AmountDiscountPolicy;
import taejung.movie.discounting.PercentDiscountPolicy;
import taejung.movie.discounting.PeriodCondition;
import taejung.movie.discounting.SequenceCondition;
import taejung.movie.pricing.AmountPricingPolicy;
import taejung.movie.pricing.AudienceAgeTypeCondition;
import taejung.movie.pricing.ScreeningDimentionCondition;
import taejung.movie.refunding.PercentRefundPolicy;
import taejung.movie.refunding.RemainTimeCondition;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

class ReservationTest {
    Movie movieAmountDiscount;
    Movie moviePercentDiscount;
    Customer heo;
    Customer tae;
    Theater theater;

    @BeforeEach
    void init() {
        movieAmountDiscount = new Movie("avatar",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))),
                new PercentRefundPolicy(0.8,
                        new RemainTimeCondition(Duration.ofHours(1))),
                new AmountPricingPolicy(
                        Money.wons(-3000),
                        new AudienceAgeTypeCondition(AudienceAgeType.TEEN)),
                new AmountPricingPolicy(
                        Money.wons(-5000),
                        new AudienceAgeTypeCondition(AudienceAgeType.CHILD)),
                new AmountPricingPolicy(
                        Money.wons(3000),
                        new ScreeningDimentionCondition(ScreeningDimension.ThreeDimensionalSpace))
        );

        moviePercentDiscount = new Movie("avatar",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new PercentDiscountPolicy(0.2,
                        new SequenceCondition(1),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))),
                new PercentRefundPolicy(0.8,
                        new RemainTimeCondition(Duration.ofHours(1))),
                new AmountPricingPolicy(
                        Money.wons(-3000),
                        new AudienceAgeTypeCondition(AudienceAgeType.TEEN)),
                new AmountPricingPolicy(
                        Money.wons(-5000),
                        new AudienceAgeTypeCondition(AudienceAgeType.CHILD)),
                new AmountPricingPolicy(
                        Money.wons(3000),
                        new ScreeningDimentionCondition(ScreeningDimension.ThreeDimensionalSpace))
        );

        theater = new Theater("제3상영관", "신촌 CGV 아트레온");
        heo = new Customer("heo", "1");
        tae = new Customer("tae", "2");
    }

    @Test
    @DisplayName("AmountDiscount SequenceCondition 테스트")
    void noDiscountTest() {
        Screening screening = new Screening(
                movieAmountDiscount,
                2,
                LocalDateTime.of(2023, 9, 8, 11, 0, 0),
                ScreeningDimension.TwoDimensionalSpace,
                theater
        );
        Reservation reservation = screening.reserve(heo, new Audience(AudienceAgeType.ADULT, 2));
        Assertions.assertThat(reservation.getFee()).isEqualTo(Money.wons(10000 * 2));
    }

    @Test
    @DisplayName("AmountDiscount SequenceCondition 테스트")
    void amountDiscountSequenceConditionTest() {
        Screening screening = new Screening(
                movieAmountDiscount,
                1,
                LocalDateTime.of(2023, 9, 8, 11, 0, 0),
                ScreeningDimension.TwoDimensionalSpace,
                theater
        );
        Reservation reservation = screening.reserve(heo, new Audience(AudienceAgeType.ADULT, 2));
        Assertions.assertThat(reservation.getFee()).isEqualTo(Money.wons(9200 * 2));
    }

    @Test
    @DisplayName("AmountDiscount PeriodCondition 테스트")
    void amountDiscountPeriodConditionTest() {
        Screening screening = new Screening(
                movieAmountDiscount,
                2,
                LocalDateTime.of(2023, 9, 7, 11, 0, 0),
                ScreeningDimension.TwoDimensionalSpace,
                theater
        );
        Reservation reservation = screening.reserve(heo, new Audience(AudienceAgeType.ADULT, 2));
        Assertions.assertThat(reservation.getFee()).isEqualTo(Money.wons(9200 * 2));
    }

    @Test
    @DisplayName("PercentDiscount SequenceCondition 테스트")
    void percentDiscountSequenceConditionTest() {
        Screening screening = new Screening(
                moviePercentDiscount,
                1,
                LocalDateTime.of(2023, 9, 8, 11, 0, 0),
                ScreeningDimension.TwoDimensionalSpace,
                theater
        );
        Reservation reservation = screening.reserve(heo, new Audience(AudienceAgeType.ADULT, 2));
        Assertions.assertThat(reservation.getFee()).isEqualTo(Money.wons(10000 * 0.8 * 2));
    }

    @Test
    @DisplayName("PercentDiscount PeriodCondition 테스트")
    void percentDiscountPeriodConditionTest() {
        Screening screening = new Screening(
                moviePercentDiscount,
                2,
                LocalDateTime.of(2023, 9, 7, 11, 0, 0),
                ScreeningDimension.TwoDimensionalSpace,
                theater
        );
        Reservation reservation = screening.reserve(heo, new Audience(AudienceAgeType.ADULT, 2));
        Assertions.assertThat(reservation.getFee()).isEqualTo(Money.wons(10000 * 0.8 * 2));
    }

    @Test
    @DisplayName("Pricing ScreeningDimensionCondition 테스트")
    void pricingScreeningDimensionConditionTest() {
        Screening screening = new Screening(
                moviePercentDiscount,
                2,
                LocalDateTime.of(2023, 9, 8, 11, 0, 0),
                ScreeningDimension.ThreeDimensionalSpace,
                theater
        );
        Reservation reservation = screening.reserve(heo, new Audience(AudienceAgeType.ADULT, 2));
        Assertions.assertThat(reservation.getFee()).isEqualTo(Money.wons((10000 + 3000) * 2));

        Screening screening2 = new Screening(
                moviePercentDiscount,
                1,
                LocalDateTime.of(2023, 9, 8, 11, 0, 0),
                ScreeningDimension.ThreeDimensionalSpace,
                theater
        );
        Reservation reservation2 = screening2.reserve(heo, new Audience(AudienceAgeType.ADULT, 2));
        Assertions.assertThat(reservation2.getFee()).isEqualTo(Money.wons((((10000 + 3000) * 0.8) * 2)));
    }

    @Test
    @DisplayName("Pricing AudienceAgeTypeCondition 테스트")
    void pricingAudienceAgeTypeConditionTest() {
        Screening screening = new Screening(
                moviePercentDiscount,
                2,
                LocalDateTime.of(2023, 9, 8, 11, 0, 0),
                ScreeningDimension.TwoDimensionalSpace,
                theater
        );
        Reservation reservation = screening.reserve(heo, new Audience(AudienceAgeType.TEEN, 2));
        Assertions.assertThat(reservation.getFee()).isEqualTo(Money.wons((10000 - 3000) * 2));

        Screening screening2 = new Screening(
                moviePercentDiscount,
                1,
                LocalDateTime.of(2023, 9, 8, 11, 0, 0),
                ScreeningDimension.TwoDimensionalSpace,
                theater
        );
        Reservation reservation2 = screening2.reserve(heo, new Audience(AudienceAgeType.CHILD, 2));
        Assertions.assertThat(reservation2.getFee()).isEqualTo(Money.wons((((10000 - 5000) * 0.8) * 2)));
    }


    @Test
    @DisplayName("Pricing 테스트")
    void pricingTest() {
        Screening screening = new Screening(
                moviePercentDiscount,
                2,
                LocalDateTime.of(2023, 9, 8, 11, 0, 0),
                ScreeningDimension.ThreeDimensionalSpace,
                theater
        );
        Reservation reservation = screening.reserve(heo, new Audience(AudienceAgeType.TEEN, 2));
        Assertions.assertThat(reservation.getFee()).isEqualTo(Money.wons((10000 + 3000 - 3000) * 2));

        Screening screening2 = new Screening(
                moviePercentDiscount,
                1,
                LocalDateTime.of(2023, 9, 8, 11, 0, 0),
                ScreeningDimension.ThreeDimensionalSpace,
                theater
        );
        Reservation reservation2 = screening2.reserve(heo, new Audience(AudienceAgeType.CHILD, 2));
        Assertions.assertThat(reservation2.getFee()).isEqualTo(Money.wons((((10000 + 3000 - 5000) * 0.8) * 2)));
    }

    @Test
    @DisplayName("환불 금액 출력")
    void refundTest() {
        Screening screening = new Screening(
                moviePercentDiscount,
                2,
                LocalDateTime.of(2023, 9, 8, 11, 0, 0),
                ScreeningDimension.ThreeDimensionalSpace,
                theater
        );
        Reservation reservation = screening.reserve(heo, new Audience(AudienceAgeType.TEEN, 2));
        Assertions.assertThat(reservation.refund()).isEqualTo(Money.wons(((10000 + 3000 - 3000) * 2) * 0.8));

        Screening screening2 = new Screening(
                moviePercentDiscount,
                1,
                LocalDateTime.of(2023, 9, 8, 11, 0, 0),
                ScreeningDimension.ThreeDimensionalSpace,
                theater
        );
        Reservation reservation2 = screening2.reserve(heo, new Audience(AudienceAgeType.CHILD, 2));
        Assertions.assertThat(reservation2.refund()).isEqualTo(Money.wons((((10000 - 5000 + 3000) * 2) * 0.8) * 0.8));
    }
}