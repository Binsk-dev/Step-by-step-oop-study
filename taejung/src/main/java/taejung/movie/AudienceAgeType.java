package taejung.movie;

public enum AudienceAgeType {
    ADULT("성인"),
    TEEN("청소년"),
    CHILD("어린이");

    final String name;

    AudienceAgeType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
