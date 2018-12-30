package part1;

interface PriceIntf {
    double getCharge(int daysRented);
    default int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}

public enum Price implements PriceIntf {
    REGULAR {

        public double getCharge(int daysRented) {
            double result = 2;
            if (daysRented > 2)
                result += (daysRented - 2) * 1.5;
            return result;
        }
    },
    NEW_RELEASE {

        public double getCharge(int daysRented) {
            return daysRented * 3;
        }

        public int getFrequentRenterPoints(int daysRented) {
            return (daysRented > 1) ? 2 : 1;
        }
    },
    CHILDRENS {

        public double getCharge(int daysRented) {
            double result = 1.5;
            if (daysRented > 3)
                result += (daysRented - 3) * 1.5;
            return result;
        }
    },
}