package chan.movie.movie.step02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MovieCategoryTest {
    MovieCategory twoDimension = MovieCategory.TWO_DIMENSION;
    MovieCategory threeDimension = MovieCategory.THREE_DIMENSION;
    MovieCategory fourDimension = MovieCategory.FOUR_DIMENSION;
    MovieCategory iMax = MovieCategory.IMAX;

    @Test
    void valueOf() {
        // 2D 영화의 MovieCharge는 15000입니다.
        Assertions.assertThat(twoDimension.movieCharge).isEqualTo(15000);

    }
}