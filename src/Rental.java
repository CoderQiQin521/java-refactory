/**
 * 租赁: 某个顾客租了一步影片
 */
public class Rental {
    Movie _movie;
    private int _daysRented; // 租用天数

    public Rental(Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    // 获取租用天数
    public int getDaysRented() {
        return _daysRented;
    }

    // 获取租用影片
    public Movie getMovie() {
        return _movie;
    }

    double getCharge() {
        return _movie.getCharge(_daysRented);
    }

    int getFrequentRenterPoints() {
        return _movie.getFrequentRenterPoints(_daysRented);
        
    }
}
