package taejung.movie;

public enum ScreeningDimension {
    TwoDimensionalSpace("2D"),
    ThreeDimensionalSpace("3D");

    private final String value;
    private ScreeningDimension(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
