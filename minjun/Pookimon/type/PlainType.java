package Pookimon.type;

public class PlainType implements Type{
    @Override
    public String getTypeName() {return "일반";}
    @Override
    public int calculatePower(int power, Type offensivePower) {
        return power;
    }
}
