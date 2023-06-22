import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NonOverlappingSegments {
    public static void main(String[] args) {
        int[][] segments = {{1, 3}, {5, 7}, {9, 11}};
        int[] newSegment = {4, 6};

        int[][] updatedSegments = addSegment(segments, newSegment);

        for (int[] segment : updatedSegments) {
            System.out.println(Arrays.toString(segment));
        }
    }
    static class Segment {
        int start;
        int end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int[][] addSegment(int[][] segments, int[] newSegment) {
        List<int[]> mergedSegments = new ArrayList<>();

        // Добавляем новый отрезок в массив существующих отрезков
        int[][] allSegments = new int[segments.length + 1][2];
        System.arraycopy(segments, 0, allSegments, 0, segments.length);
        allSegments[segments.length] = newSegment;

        // Сортируем отрезки по начальной точке
        Arrays.sort(allSegments, Comparator.comparingInt(a -> a[0]));

        // Объединяем пересекающиеся отрезки
        int[] currentSegment = allSegments[0];
        for (int i = 1; i < allSegments.length; i++) {
            int[] nextSegment = allSegments[i];
            if (currentSegment[1] >= nextSegment[0]) {
                // Отрезки пересекаются, расширяем текущий отрезок
                currentSegment[1] = Math.max(currentSegment[1], nextSegment[1]);
            } else {
                // Отрезки не пересекаются, добавляем текущий отрезок и обновляем текущий отрезок
                mergedSegments.add(currentSegment);
                currentSegment = nextSegment;
            }
        }

        // Добавляем последний текущий отрезок
        mergedSegments.add(currentSegment);

        // Преобразуем список в двумерный массив
        int[][] result = new int[mergedSegments.size()][2];
        for (int i = 0; i < mergedSegments.size(); i++) {
            result[i] = mergedSegments.get(i);
        }

        return result;
    }
}
