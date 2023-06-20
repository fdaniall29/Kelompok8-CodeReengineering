public class ShapeCalculator {
    public static int calculateSquareArea(int side) {
        return side * side;
    }

    public static int calculateRectangleArea(int width, int height) {
        return width * height;
    }

    public static double calculateCircleArea(int radius) {
        return Math.PI * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        int squareSide = 7;
        int rectangleWidth = 8;
        int rectangleHeight = 3;
        int circleRadius = 10;

        int squareArea = ShapeCalculator.calculateSquareArea(squareSide);
        int rectangleArea = ShapeCalculator.calculateRectangleArea(rectangleWidth, rectangleHeight);
        double circleArea = ShapeCalculator.calculateCircleArea(circleRadius);

        System.out.println("Area of square: " + squareArea);
        System.out.println("Area of rectangle: " + rectangleArea);
        System.out.println("Area of circle: " + circleArea);
    }
}
