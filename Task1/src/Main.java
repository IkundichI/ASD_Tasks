import java.util.*;


public class Main {
    public static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {

        int[] numbers = {3, 61, 7, 21, 234, 23, 2, 62};
        Pair[] pairs = new Pair[59];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair(0, 0);
        }
        for (int i = 0; i < numbers.length; i++) {
            int elem = numbers[i] % 59;
            int summ = pairs[elem].first + pairs[elem].second + numbers[i];
            int maxOf = Math.max(Math.max(pairs[elem].second, pairs[elem].first), numbers[i]);
            int minOf = Math.min(Math.min(pairs[elem].second, pairs[elem].first), numbers[i]);
            pairs[elem] = new Pair(maxOf, summ - minOf - maxOf);
        }
        int[] result = new int[2];
        int maxMultik = 0;
        for (int i = 0; i < pairs.length; i++) {
            if (maxMultik < (pairs[i].first * pairs[i].second)) {
                maxMultik = (pairs[i].first * pairs[i].second);
                result[0] = pairs[i].first;
                result[1] = pairs[i].second;
            }
        }
        System.out.println(Arrays.toString(result));

    }
}
