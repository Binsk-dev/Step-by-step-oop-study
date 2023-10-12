package org.eternity.movie.assignment2;

import org.eternity.money.Money;

public class dimension_2 implements Dimension{
    @Override
    public void showDimensionInfo() {
        System.out.println("상영유형: 2D");
    }

    @Override
    public Money calculateDimensionFee(Money money) {
        return money;
    }
}
