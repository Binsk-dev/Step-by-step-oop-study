package chan.movie.movie.step02;

public enum MovieCategory {
    TWO_DIMENSION(15000),
    THREE_DIMENSION(17000),
    FOUR_DIMENSION(18000),
    IMAX(20000);

    int movieCharge;

    MovieCategory(int movieCharge) {
        this.movieCharge = movieCharge;
    }


}
