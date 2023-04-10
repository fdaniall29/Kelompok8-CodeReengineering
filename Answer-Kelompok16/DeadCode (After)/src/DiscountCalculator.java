// package dead_code; (dihapus karena tidak digunakan)

// import java.util.*; (dihapus karena tidak digunakan)

public class DiscountCalculator { // Nama class diubah dari 'DiscountCalculator' menjadi 'ClothingDiscountCalculator'
	public double setFinalPrice(int priceBefore) {
		double finalPrice = 0;

		if (priceBefore > 5000000) {
			finalPrice = priceBefore - (priceBefore * 0.2);
		} else { // Menambahkan else untuk menghindari perhitungan finalPrice dua kali
			finalPrice = priceBefore - (priceBefore * 0.1);
		}
		return finalPrice;
	}
}
