package divergent_change.before;

public class FullRectanglePrinter extends RectanglePrinter {
    // Konstruktor
    public FullRectanglePrinter(Rectangle r) {
        super(r);
    }

    // Implementasi method print() untuk mencetak Rectangle secara penuh
    @Override
    public void print() {
        for (int i=0; i<rectangle.getHeight(); i++) {
            for (int j=0; j<rectangle.getWidth(); j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}