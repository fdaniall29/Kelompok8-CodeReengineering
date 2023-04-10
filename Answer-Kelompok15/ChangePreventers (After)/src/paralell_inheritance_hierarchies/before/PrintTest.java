import org.junit.jupiter.api.Test;

class PrintTest {
    @Test
    void test() {
        // Membuat objek Rectangle dan mengatur lebar dan tingginya
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(5);
        rectangle.setWidth(4);
        
        // Membuat objek RectangleAreaCalculator dan memasukkan objek Rectangle sebagai parameter
        RectangleAreaCalculator calculator = new RectangleAreaCalculator(rectangle);
        
        // Menghitung luas objek Rectangle dan mencetaknya
        System.out.println(calculator.getArea());
    }
}