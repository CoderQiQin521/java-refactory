import java.util.Enumeration;
import java.util.Vector;

/**
 * 顾客
 */
public class Customer {
    private String _name; // 顾客姓名
    private Vector _rentals = new Vector(); // 租赁列表

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = getName() + "的租赁记录" + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t费用: " + String.valueOf(each.getCharge()) + "\n";
        }

        result += "总费用: " + String.valueOf(getTotalCharge()) + "\n";
        result += "积分: " + String.valueOf(getTotalFrequentRenterPoints());

        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}
