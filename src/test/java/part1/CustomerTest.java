package part1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

    private static final int REGULAR = 0;
    private static final int NEW_RELEASE = 1;
    private static final int CHILDRENS = 2;
    private Customer customer = null;

    @BeforeEach
    void init() {
        customer = new Customer("Mason");
    }

    @AfterEach
    void tearDown() {
        customer = null;
    }

    @Test
    void statementWithRegular() {

        Movie regularMovie_FA_1 = new Movie("鋼の錬金術師_11", REGULAR);
        Movie regularMovie_FA_2 = new Movie("鋼の錬金術師_2", REGULAR);
        Movie regularMovie_EVO = new Movie("Evolution", REGULAR);
        Rental shortRental = new Rental(regularMovie_FA_1, 1);
        Rental basicRental = new Rental(regularMovie_FA_2, 2);
        Rental longRental = new Rental(regularMovie_EVO, 3);
        customer.addRental(shortRental);
        customer.addRental(basicRental);
        customer.addRental(longRental);

        String expect = "Rental Record for " + customer.getName() + "\n" +
                "\t" + regularMovie_FA_1.getTitle() + "\t" + shortRental.getCharge() + "\n" +
                "\t" + regularMovie_FA_2.getTitle() + "\t" + basicRental.getCharge() + "\n" +
                "\t" + regularMovie_EVO.getTitle() + "\t" + longRental.getCharge() + "\n" +
                "Amount owed is " + 7.5 + "\n" +
                "You earned " + 3 + " frequent renter points";

        assertEquals(expect, customer.statement());
    }

    @Test
    void statementWithNewRelease() {

        Movie newReleaseMovie_FA_1 = new Movie("鋼の錬金術師_11", NEW_RELEASE);
        Movie newReleaseMovie_FA_2 = new Movie("鋼の錬金術師_2", NEW_RELEASE);
        Movie newReleaseMovie_EVO = new Movie("Evolution", NEW_RELEASE);
        Rental shortRental = new Rental(newReleaseMovie_FA_1, 1);
        Rental basicRental = new Rental(newReleaseMovie_FA_2, 2);
        Rental longRental = new Rental(newReleaseMovie_EVO, 3);
        customer.addRental(shortRental);
        customer.addRental(basicRental);
        customer.addRental(longRental);

        String expect = "Rental Record for " + customer.getName() + "\n" +
                "\t" + newReleaseMovie_FA_1.getTitle() + "\t" + shortRental.getCharge() + "\n" +
                "\t" + newReleaseMovie_FA_2.getTitle() + "\t" + basicRental.getCharge() + "\n" +
                "\t" + newReleaseMovie_EVO.getTitle() + "\t" + longRental.getCharge() + "\n" +
                "Amount owed is " + 18.0 + "\n" +
                "You earned " + 5 + " frequent renter points";

        assertEquals(expect, customer.statement());
    }

    @Test
    void statementWithChildrens() {

        Movie childrensMovie_FA_1 = new Movie("鋼の錬金術師_11", CHILDRENS);
        Movie childrensMovie_FA_2 = new Movie("鋼の錬金術師_2", CHILDRENS);
        Movie childrensMovie_EVO = new Movie("Evolution", CHILDRENS);
        Rental shortRental = new Rental(childrensMovie_FA_1, 1);
        Rental basicRental = new Rental(childrensMovie_FA_2, 3);
        Rental longRental = new Rental(childrensMovie_EVO, 4);
        customer.addRental(shortRental);
        customer.addRental(basicRental);
        customer.addRental(longRental);

        String expect = "Rental Record for " + customer.getName() + "\n" +
                "\t" + childrensMovie_FA_1.getTitle() + "\t" + shortRental.getCharge() + "\n" +
                "\t" + childrensMovie_FA_2.getTitle() + "\t" + basicRental.getCharge() + "\n" +
                "\t" + childrensMovie_EVO.getTitle() + "\t" + longRental.getCharge() + "\n" +
                "Amount owed is " + 6.0 + "\n" +
                "You earned " + 3 + " frequent renter points";

        assertEquals(expect, customer.statement());
    }
}