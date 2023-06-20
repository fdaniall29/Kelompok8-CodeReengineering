import org.junit.jupiter.api.Test;

class RectangleTest {

    @Test
    void test() {
        Rectangle r = new Rectangle(5, 3);

        assertEqual(r.area(), 15);
        
        assertEqual(r.perimeter(), 16);
        
        System.out.println("");
        
        r.printWithBorder();
        System.out.println("");
        
        r.printFull();
    }

    private void assertEqual(int actual, int expected) {
        if (actual != expected) {
            throw new AssertionError("Expected " + expected + " but got " + actual);
        }
    }
}