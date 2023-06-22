import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class RemoveDuplicates {
    public static List<Integer> removeDuplicates(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (Integer num : list) {
            if (!set.contains(num)) {
                set.add(num);
                result.add(num);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(1);

        List<Integer> uniqueList = removeDuplicates(list);
        System.out.println("Исходный список: " + list);
        System.out.println("Список без дубликатов: " + uniqueList);
    }
}
