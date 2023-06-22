public class PairCount {
    public static int countPairs(int[] nums) {
        int count = 0;
        int count61 = 0;
        for (int num: nums) {
            if (num == 61) {
                count61++;
            }
            count++;
        }
        return count61*(count - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 17, 3, 61, 61, 61};

        int pairCount = countPairs(nums);
        System.out.println("Количество пар с произведением, кратным 61: " + pairCount);
    }
}
