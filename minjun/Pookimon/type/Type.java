package Pookimon.type;

public interface Type {
    public String getTypeName();
    public int calculatePower(int power, Type offensiveType);
}
