import java.util.*;

public class MinimumPossibleNumber {
    public static String getMinimumPossibleNumber(List<Integer> numbers) {
        Integer[] integers = numbers.toArray(new Integer[0]);
        Arrays.sort(integers, new NumberComparator());

        StringBuilder result = new StringBuilder();
        for (Integer num : integers) {
            result.append(num);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(54, 546, 548, 60);
        String minimumPossibleNumber = getMinimumPossibleNumber(numbers);
        System.out.println("Minimum Possible Number: " + minimumPossibleNumber);
    }
}
