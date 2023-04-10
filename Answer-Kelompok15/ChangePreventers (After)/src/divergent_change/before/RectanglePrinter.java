public interface ShapePrinter {
    void print();
}

public class RectanglePrinter implements ShapePrinter {
    private Rectangle r;
    
    public RectanglePrinter(Rectangle r) {
        this.r = r;
    }

    public void print() {
        System.out.println("Rectangle with width " + r.getWidth() + " and height " + r.getHeight());
    }
}
