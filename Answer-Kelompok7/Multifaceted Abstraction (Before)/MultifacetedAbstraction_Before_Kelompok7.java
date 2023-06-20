public class Rectangle {
	private int width;
	private int height;
	
	public Rectangle(int width, int height) {
		if(width <= 0 || height <= 0) {
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
	
	public void print(String style) {
		style = style.toLowerCase();
		if(style.equals("full")) {
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					System.out.print("*");
				}
				System.out.println("");
			}
		} else if(style.equals("border")) {
			for(int i = 0; i < height; i++) {
				for(int j = 0; j < width; j++) {
					System.out.print(
							j == 0 || j == width-1 || 
							i == 0 || i == height-1 ? "*" : " ");
				}
				System.out.println("");
			}
		} else {
			System.out.println("style not recognized");
		}
	}
}


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectangleTest {

	@Test
	void test() {
		Rectangle r = new Rectangle(5, 3);
		assertEquals(r.area(), 15);
		assertEquals(r.perimeter(), 16);
		
		r.print("border");
		System.out.println("");
		r.print("full");
	}

}