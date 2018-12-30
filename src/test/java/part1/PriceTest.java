package part1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PriceTest {

    @Test
    void getPriceCodeTest() {

        Price regularPrice = new RegularPrice();
        Price childrensPrice = new ChildrensPrice();
        Price newReleasePrice = new NewReleasePrice();

        assertEquals(Movie.REGULAR, regularPrice.getPriceCode());
        assertEquals(Movie.CHILDRENS, childrensPrice.getPriceCode());
        assertEquals(Movie.NEW_RELEASE, newReleasePrice.getPriceCode());
    }

    @Test
    void getPriceTest() {

        Price regularPrice = new RegularPrice();
        assertEquals(2.0, regularPrice.getCharge(1));
        assertEquals(2.0, regularPrice.getCharge(2));
        assertEquals(3.5, regularPrice.getCharge(3));

        Price newReleasePrice = new NewReleasePrice();
        assertEquals(3.0, newReleasePrice.getCharge(1));
        assertEquals(6.0, newReleasePrice.getCharge(2));
        assertEquals(9.0, newReleasePrice.getCharge(3));

        Price childrensPrice = new ChildrensPrice();
        assertEquals(1.5, childrensPrice.getCharge(1));
        assertEquals(1.5, childrensPrice.getCharge(3));
        assertEquals(3.0, childrensPrice.getCharge(4));
    }
}