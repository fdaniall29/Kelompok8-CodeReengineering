package paralell_inheritance_hierarchies.before;

public class TriangleAreaCalculator {
    private Shape2D shape;
    
    public TriangleAreaCalculator(Shape2D shape) {
        this.shape = shape;
    }
    
    // Mengembalikan luas dari objek Shape2D yang disimpan dalam variabel shape
    public float getArea() {
        return shape.getWidth() * shape.getHeight() / 2;
    }
}
