import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CountUniqueNumbers {
    public static int countUniqueNumbers(int[] nums) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int num : nums) {
            uniqueNumbers.add(num);
        }

        return uniqueNumbers.size();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 5, 5, 6, 6, 6};
        int count = countUniqueNumbers(nums);
        System.out.println("Количество различных чисел: " + count);
    }
}
