package paralell_inheritance_hierarchies.before;

public class Rectangle implements Shape2D {
    // Menambahkan variabel width dan height
    private float width;
    private float height;
    
    // Menambahkan constructor untuk mengatur nilai width dan height
    public Rectangle(float width, float height) {
        this.width = width;
        this.height = height;
    }
    
    // Implementasi method getArea() untuk menghitung luas Rectangle
    public float getArea() {
        return width * height;
    }
    
    // Implementasi method getPerimeter() untuk menghitung keliling Rectangle
    public float getPerimeter() {
        return 2 * (width + height);
    }
    
    // Menambahkan getter dan setter untuk variabel width dan height
    public float getWidth() {
        return width;
    }
    
    public void setWidth(float width) {
        this.width = width;
    }
    
    public float getHeight() {
        return height;
    }
    
    public void setHeight(float height) {
        this.height = height;
    }
}
