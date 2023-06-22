public class TwoDimensionalBinarySearch {
    public static boolean search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;


            int midValue = matrix[mid / cols][mid % cols];


            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5},
                {7, 9, 11},
                {13, 15, 17}
        };

        int target = 12;
        boolean found = search(matrix, target);

        if (found) {
            System.out.println("Число " + target + " найдено в массиве.");
        } else {
            System.out.println("Число " + target + " не найдено в массиве.");
        }
    }
}
