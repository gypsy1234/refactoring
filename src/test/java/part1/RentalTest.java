package part1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RentalTest {

    private static final int REGULAR = 0;
    private static final int NEW_RELEASE = 1;
    private static final int CHILDRENS = 2;

    @Test
    void getChargeTest() {

        Movie regularMovie = new Movie("鋼の錬金術師_11", REGULAR);
        Movie newReleaseMovie = new Movie("鋼の錬金術師_2", NEW_RELEASE);
        Movie childrensMovie = new Movie("Evolution", CHILDRENS);

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

        Movie regularMovie_FA_1 = new Movie("鋼の錬金術師_11", REGULAR);
        Movie childrensMovie_FA_1 = new Movie("鋼の錬金術師_11", CHILDRENS);
        Movie newReleaseMovie_FA_1 = new Movie("鋼の錬金術師_11", NEW_RELEASE);

        Rental regularShortRental = new Rental(regularMovie_FA_1, 1);
        Rental regularLongRental = new Rental(regularMovie_FA_1, 2);

        Rental childrensShortRental = new Rental(childrensMovie_FA_1, 1);
        Rental childrensLongRental = new Rental(childrensMovie_FA_1, 2);

        Rental newShortRental = new Rental(newReleaseMovie_FA_1, 1);
        Rental newLongRental = new Rental(newReleaseMovie_FA_1, 2);


        assertEquals(1, regularShortRental.getFrequentRenterPoints());
        assertEquals(1, regularLongRental.getFrequentRenterPoints());
        assertEquals(1, childrensShortRental.getFrequentRenterPoints());
        assertEquals(1, childrensLongRental.getFrequentRenterPoints());
        assertEquals(1, newShortRental.getFrequentRenterPoints());
        assertEquals(2, newLongRental.getFrequentRenterPoints());
    }
}