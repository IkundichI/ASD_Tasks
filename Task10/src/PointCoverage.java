import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class PointCoverage {
    static class Segment {
        int start;
        int end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(1, 3));
        segments.add(new Segment(2, 5));
        segments.add(new Segment(4, 7));
        segments.add(new Segment(6, 9));

        int k = 2; // Искомое значение k

        List<Integer> points = findPointsCoverage(segments, k);

        System.out.println("Points covered by at least " + k + " segments: " + points);
    }

    public static List<Integer> findPointsCoverage(List<Segment> segments, int k) {
        List<Integer> points = new ArrayList<>();

        // Сортировка отрезков по правой границе
        segments.sort(Comparator.comparingInt(segment -> segment.end));

        int currentEnd = segments.get(0).end;
        int count = 1; // Количество отрезков, покрывающих текущую точку

        for (int i = 1; i < segments.size(); i++) {
            Segment segment = segments.get(i);

            if (segment.start > currentEnd) {
                // Текущая точка не покрыта предыдущими отрезками
                if (count >= k) {
                    // Добавляем точку, если она покрыта k или более отрезками
                    points.add(currentEnd);
                }

                currentEnd = segment.end;
                count = 1;
            } else {
                // Текущая точка покрыта предыдущими отрезками
                currentEnd = Math.min(currentEnd, segment.end);
                count++;
            }
        }

        // Добавляем последнюю точку, если она покрыта k или более отрезками
        if (count >= k) {
            points.add(currentEnd);
        }

        return points;
    }
}
