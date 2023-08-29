package org.eternity.movie.assignment2;

import org.eternity.money.Money;

public class dimension_3 implements Dimension{
    @Override
    public void showDimensionInfo() {
        System.out.println("상영유형: 3D");
    }

    @Override
    public Money calculateDimensionFee(Money money) {
        return money.times(1.2);
    }
}
