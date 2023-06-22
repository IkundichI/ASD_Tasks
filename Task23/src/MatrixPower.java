public class MatrixPower {
    private static int[][] multiplyMatrix(int[][] a, int[][] b, int p) {
        int size = a.length;
        int[][] result = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] = (result[i][j] + (a[i][k] * b[k][j]) % p) % p;
                }
            }
        }

        return result;
    }

    private static int[][] powerMatrix(int[][] matrix, int n, int p) {
        int size = matrix.length;

        // Базовый случай: степень равна 0, возвращаем единичную матрицу
        if (n == 0) {
            int[][] identity = new int[size][size];
            for (int i = 0; i < size; i++) {
                identity[i][i] = 1;
            }
            return identity;
        }

        // Рекурсивно находим матрицу, возведенную в степень n / 2
        int[][] temp = powerMatrix(matrix, n / 2, p);

        // Умножаем полученную матрицу саму на себя
        int[][] result = multiplyMatrix(temp, temp, p);

        // Если степень нечетная, умножаем полученную матрицу на исходную
        if (n % 2 == 1) {
            result = multiplyMatrix(result, matrix, p);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int n = 3;
        int p = 100000;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        int[][] result = powerMatrix(matrix, n, p);

        System.out.println("Результат:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
