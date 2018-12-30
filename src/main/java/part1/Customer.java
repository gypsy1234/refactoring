package part1;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String _name;
    private List<Rental> _rentals = new ArrayList<>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.add(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : _rentals) {
            // レンタルポイントを加算
            frequentRenterPoints += rental.getFrequentRenterPoints();
            // この貸し出しに関する数値の表示
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n";
            totalAmount += rental.getCharge();
        }

        // フッタ部分の追加
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }
}