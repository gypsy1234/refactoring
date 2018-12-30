package part1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PriceTest {

    private Price regularPrice = null;
    private Price childrensPrice = null;
    private Price newReleasePrice = null;

    @BeforeEach
    void init() {
        regularPrice = new RegularPrice();
        childrensPrice = new ChildrensPrice();
        newReleasePrice = new NewReleasePrice();
    }

    @AfterEach
    void tearDown() {
        regularPrice = null;
        childrensPrice = null;
        newReleasePrice = null;
    }

    @Test
    void getPriceCodeTest() {
        assertEquals(Movie.REGULAR, regularPrice.getPriceCode());
        assertEquals(Movie.CHILDRENS, childrensPrice.getPriceCode());
        assertEquals(Movie.NEW_RELEASE, newReleasePrice.getPriceCode());
    }

    @Test
    void getPriceTest() {

        assertEquals(2.0, regularPrice.getCharge(1));
        assertEquals(2.0, regularPrice.getCharge(2));
        assertEquals(3.5, regularPrice.getCharge(3));

        assertEquals(3.0, newReleasePrice.getCharge(1));
        assertEquals(6.0, newReleasePrice.getCharge(2));
        assertEquals(9.0, newReleasePrice.getCharge(3));

        assertEquals(1.5, childrensPrice.getCharge(1));
        assertEquals(1.5, childrensPrice.getCharge(3));
        assertEquals(3.0, childrensPrice.getCharge(4));
    }

    @Test
    void getFrequentRenterPointTest() {
        assertEquals(1, regularPrice.getFrequentRenterPoints(1));
        assertEquals(1, regularPrice.getFrequentRenterPoints(2));

        assertEquals(1, childrensPrice.getFrequentRenterPoints(1));
        assertEquals(1, childrensPrice.getFrequentRenterPoints(2));

        assertEquals(1, newReleasePrice.getFrequentRenterPoints(1));
        assertEquals(2, newReleasePrice.getFrequentRenterPoints(2));
        assertEquals(2, newReleasePrice.getFrequentRenterPoints(3));
    }
}