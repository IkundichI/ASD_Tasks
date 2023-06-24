import java.util.Comparator;

public class NumberComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer num1, Integer num2) {
        String combination1 = num1.toString() + num2.toString();
        String combination2 = num2.toString() + num1.toString();
        return combination1.compareTo(combination2);
    }
}
