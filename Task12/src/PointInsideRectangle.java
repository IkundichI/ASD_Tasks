
public class PointInsideRectangle {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Rectangle {
        int a;
        int b;
        int c;
        int d;

        public Rectangle(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }
    public static int countPointsInsideRectangle(Point[] points, Rectangle rectangle) {
        int count = 0;

        for (Point point : points) {
            if (point.x >= rectangle.a && point.x <= rectangle.b &&
                    point.y >= rectangle.c && point.y <= rectangle.d) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Point[] points = {
                new Point(1, 2),
                new Point(3, 4),
                new Point(5, 6),
        };

        Rectangle rectangle = new Rectangle(2, 4, 3, 5);

        int count = countPointsInsideRectangle(points, rectangle);
        System.out.println("Количество точек внутри прямоугольника: " + count);
    }
}
