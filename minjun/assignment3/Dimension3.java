package org.eternity.movie.assignment3;

import org.eternity.money.Money;

public class Dimension3 implements Dimension{
    @Override
    public void showDimensionInfo() {
        System.out.println("상영유형: 3D");
    }

    @Override
    public Money calculateDimensionFee(Money money) {
        return money.plus(Money.wons(1000));
    }
}
