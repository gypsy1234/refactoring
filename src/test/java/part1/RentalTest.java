package part1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class RentalTest {

    private static final int REGULAR = 0;
    private static final int NEW_RELEASE = 1;
    private static final int CHILDRENS = 2;

    @Test
    void getChargeWithRegular() {

        Movie regularMovie_FA_1 = new Movie("鋼の錬金術師_11", REGULAR);
        Movie regularMovie_FA_2 = new Movie("鋼の錬金術師_2", REGULAR);
        Movie regularMovie_EVO = new Movie("Evolution", REGULAR);
        Rental shortRental = new Rental(regularMovie_FA_1, 1);
        Rental basicRental = new Rental(regularMovie_FA_2, 2);
        Rental longRental = new Rental(regularMovie_EVO, 3);

        assertEquals(2.0, shortRental.getCharge());
        assertEquals(2.0, basicRental.getCharge());
        assertEquals(3.5, longRental.getCharge());
    }

    @Test
    void getChargeWithNewRelease() {

        Movie newReleaseMovie_FA_1 = new Movie("鋼の錬金術師_11", NEW_RELEASE);
        Movie newReleaseMovie_FA_2 = new Movie("鋼の錬金術師_2", NEW_RELEASE);
        Movie newReleaseMovie_EVO = new Movie("Evolution", NEW_RELEASE);
        Rental shortRental = new Rental(newReleaseMovie_FA_1, 1);
        Rental basicRental = new Rental(newReleaseMovie_FA_2, 2);
        Rental longRental = new Rental(newReleaseMovie_EVO, 3);

        assertEquals(3.0, shortRental.getCharge());
        assertEquals(6.0, basicRental.getCharge());
        assertEquals(9.0, longRental.getCharge());
    }

    @Test
    void getChargeWithChildrens() {

        Movie childrensMovie_FA_1 = new Movie("鋼の錬金術師_11", CHILDRENS);
        Movie childrensMovie_FA_2 = new Movie("鋼の錬金術師_2", CHILDRENS);
        Movie childrensMovie_EVO = new Movie("Evolution", CHILDRENS);
        Rental shortRental = new Rental(childrensMovie_FA_1, 1);
        Rental basicRental = new Rental(childrensMovie_FA_2, 3);
        Rental longRental = new Rental(childrensMovie_EVO, 4);

        assertEquals(1.5, shortRental.getCharge());
        assertEquals(1.5, basicRental.getCharge());
        assertEquals(3.0, longRental.getCharge());
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