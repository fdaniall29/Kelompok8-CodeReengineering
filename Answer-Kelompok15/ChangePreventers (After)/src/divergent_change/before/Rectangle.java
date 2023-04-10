public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 3);

        RectanglePrinter.printFull(rectangle);
        System.out.println();
        RectanglePrinter.printBorder(rectangle);
    }
}

class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width and height must be greater than zero");
        }

        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

class RectanglePrinter {
    public static void printFull(Rectangle rectangle) {
        for (int i = 0; i < rectangle.getHeight(); i++) {
            for (int j = 0; j < rectangle.getWidth(); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printBorder(Rectangle rectangle) {
        for (int i = 0; i < rectangle.getHeight(); i++) {
            for (int j = 0; j < rectangle.getWidth(); j++) {
                System.out.print(
                    j == 0 || j == rectangle.getWidth() - 1 ||
                    i == 0 || i == rectangle.getHeight() - 1 ? "*" : " ");
            }
            System.out.println();
        }
    }
}