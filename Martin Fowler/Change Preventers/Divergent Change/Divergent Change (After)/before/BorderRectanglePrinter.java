package divergent_change.after;

public class BorderRectanglePrinter extends RectanglePrinter {
    // Konstruktor
    public BorderRectanglePrinter(Rectangle r) {
        super(r);
    }

    // Implementasi method print() untuk mencetak Rectangle dengan batas
    @Override
    public void print() {
        // Cetak batas atas
        for (int i = 0; i < rectangle.getWidth() + 2; i++) {
            System.out.print("#");
        }
        System.out.println();

        // Cetak isi dan batas sisi
        for (int i = 0; i < rectangle.getHeight(); i++) {
            System.out.print("#");
            for (int j = 0; j < rectangle.getWidth(); j++) {
                System.out.print(" ");
            }
            System.out.println("#");
        }

        // Cetak batas bawah
        for (int i = 0; i < rectangle.getWidth() + 2; i++) {
            System.out.print("#");
        }
        System.out.println();
    }
}