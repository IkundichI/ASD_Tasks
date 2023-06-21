public class FindSingleNumber {
    public static int findSingleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4, 5, 7, 7, 8, 8};
        int singleNumber = findSingleNumber(nums);
        System.out.println("Single number: " + singleNumber);
    }
}
