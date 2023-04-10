package paralell_inheritance_hierarchies.before;

public class RectangleAreaCalculator {
    private Shape2D shape;
    
    public RectangleAreaCalculator(Shape2D shape) {
        this.shape = shape;
    }
    
    // Mengembalikan luas dari objek Shape2D yang disimpan dalam variabel shape
    public float getArea() {
        return shape.getWidth() * shape.getHeight();
    }
}
