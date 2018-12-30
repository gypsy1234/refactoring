package part1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentalTest {

    private Movie regularMovie = null;
    private Movie newReleaseMovie = null;
    private Movie childrensMovie = null;

    @BeforeEach
    void init() {
        regularMovie = new Movie("鋼の錬金術師_11", Price.REGULAR);
        newReleaseMovie = new Movie("鋼の錬金術師_2", Price.NEW_RELEASE);
        childrensMovie = new Movie("Evolution", Price.CHILDRENS);
    }

    @AfterEach
    void tearDown() {
        regularMovie = null;
        newReleaseMovie = null;
        childrensMovie = null;
    }


    @Test
    void getChargeTest() {
        assertCharge(regularMovie);
        assertCharge(newReleaseMovie);
        assertCharge(childrensMovie);
    }

    private void assertCharge(Movie movie) {
        for (int i = 1; i < 10; i++) {
            Rental rental = new Rental(movie, i);
            assertEquals(movie.getCharge(i), rental.getCharge());
        }
    }

    @Test
    void getFrequentRenterPointsTest() {
        assertFrequentPoint(regularMovie);
        assertFrequentPoint(childrensMovie);
        assertFrequentPoint(newReleaseMovie);
    }

    private void assertFrequentPoint(Movie movie) {
        for (int i = 1; i < 5; i++) {
            Rental rental = new Rental(movie, i);
            assertEquals(movie.getFrequentRenterPoints(i), rental.getFrequentRenterPoints());
        }
    }
}