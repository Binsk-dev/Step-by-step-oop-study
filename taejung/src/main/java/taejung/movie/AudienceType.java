package taejung.movie;

public enum AudienceType {
    ADULT("성인"),
    TEENS("청소년"),
    CHILDREN("어린이");

    final String name;

    AudienceType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
