public class CubeRoot {
    public static int cubeRoot(int x) {
        if (x <= 1) {
            return x; // Если x <= 1, то округленный вниз корень третьей степени будет равен x
        }

        int left = 0;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cube = mid * mid * mid;

            if (cube == x) {
                return mid; // Найдено точное значение корня третьей степени
            } else if (cube > x) {
                right = mid - 1; // Искомое значение находится в левой половине диапазона
            } else {
                left = mid + 1; // Искомое значение находится в правой половине диапазона
            }
        }

        return right; // Возвращаем округленное вниз значение
    }

    public static void main(String[] args) {
        int x = 28;
        int result = cubeRoot(x);
        System.out.println("Округленный вниз корень третьей степени из " + x + " равен: " + result);
    }
}
