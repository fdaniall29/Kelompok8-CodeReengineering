// package dead_code; (dihapus karena tidak digunakan)

// import java.util.*; (dihapus karena tidak digunakan)

public class Clothes { // Nama class diubah dari 'Clothes' menjadi 'ClothingItem'
	protected String name;
	protected String size;
	protected int price;

	public Clothes(String name, String size, int price) {
		super();
		this.name = name;
		this.size = size;
		this.price = price;
	}

	public String getName() { // Menambahkan getter untuk 'name'
		return name;
	}

	public void setName(String name) { // Menambahkan setter untuk 'name'
		this.name = name;
	}

	public String getSize() { // Menambahkan getter untuk 'size'
		return size;
	}

	public void setSize(String size) { // Menambahkan setter untuk 'size'
		this.size = size;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
