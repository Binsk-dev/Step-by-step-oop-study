package taejung.movie;

public class Theater {

    private String name;
    private String cinamaName;

    public Theater(String cinema) {
        this.cinamaName = cinema;
    }

    public String getName() {
        return name;
    }

    public String getCinamaName(){
        return cinamaName;
    }
}
