public class Rectangle {
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

    public int area() {
        return width * height;
    }

    public int perimeter() {
        return 2 * (width + height);
    }
}

public class RectanglePrinter {
    public void printRectangle(Rectangle rectangle, String style) {
        style = style.toLowerCase();
        if (style.equals("full")) {
            printFullRectangle(rectangle);
        } else if (style.equals("border")) {
            printBorderRectangle(rectangle);
        } else {
            System.out.println("Style not recognized");
        }
    }

    private void printFullRectangle(Rectangle rectangle) {
        for (int i = 0; i < rectangle.getHeight(); i++) {
            for (int j = 0; j < rectangle.getWidth(); j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    private void printBorderRectangle(Rectangle rectangle) {
        for (int i = 0; i < rectangle.getHeight(); i++) {
            for (int j = 0; j < rectangle.getWidth(); j++) {
                System.out.print(
                        j == 0 || j == rectangle.getWidth() - 1 ||
                                i == 0 || i == rectangle.getHeight() - 1 ? "*" : " ");
            }
            System.out.println("");
        }
    }
}
