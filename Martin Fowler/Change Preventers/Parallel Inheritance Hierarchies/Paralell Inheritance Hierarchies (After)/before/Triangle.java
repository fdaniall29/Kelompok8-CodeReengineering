package paralell_inheritance_hierarchies.before;

public class Triangle implements Shape2D {
    // Menambahkan variabel base dan height
    private float base;
    private float height;
    
    // Menambahkan constructor untuk mengatur nilai base dan height
    public Triangle(float base, float height) {
        this.base = base;
        this.height = height;
    }
    
    // Implementasi method getArea() untuk menghitung luas Triangle
    public float getArea() {
        return base * height / 2;
    }
    
    // Menambahkan getter dan setter untuk variabel base dan height
    public float getBase() {
        return base;
    }
    
    public void setBase(float base) {
        this.base = base;
    }
    
    public float getHeight() {
        return height;
    }
    
    public void setHeight(float height) {
        this.height = height;
    }
}