package taejung.movie;

public class Theater {

    private String name;
    private String cinemaName;

    public Theater(String name, String cinema) {
        this.name = name;
        this.cinemaName = cinema;
    }

    public String getName() {
        return name;
    }

    public String getCinemaName(){
        return cinemaName;
    }
}
