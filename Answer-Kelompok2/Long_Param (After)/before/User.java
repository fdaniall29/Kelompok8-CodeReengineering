public class User {
	private String name;
	private String email;
	private Wallet wallet;
	
	public User(String name, String email) {
		this.name = name;
		this.email = email;
		this.wallet = new Wallet(); // Pembuatan objek Wallet dipindahkan ke dalam constructor
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Wallet getWallet() {
		return wallet;
	}
}