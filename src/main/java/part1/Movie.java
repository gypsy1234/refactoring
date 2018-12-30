package part1;

public class Movie {
    
    private String _title;
    private PriceIntf _price;

    public Movie(String title, PriceIntf price) {
        _title = title;
        _price = price;
    }

    public PriceIntf getPrice() {
        return _price;
    }

    public void setPrice(PriceIntf price) {
        _price = price;
    }

    public String getTitle() {
        return _title;
    }

    double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);
    }
}