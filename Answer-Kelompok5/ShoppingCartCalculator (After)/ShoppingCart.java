import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    // Atribut items untuk menyimpan daftar item dalam keranjang
    private List<Item> items;

    // Konstruktor
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    // Menambahkan item kedalam keranjang
    public void addItem(Item item) {
        items.add(item);
    }

    // Menghitung total harga
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter item name (or 'exit' to quit):");
            String itemName = scanner.nextLine();
            if (itemName.equals("exit")) {
                break;
            }
            System.out.println("Enter item price:");
            double itemPrice = Double.parseDouble(scanner.nextLine());
            Item item = new Item(itemName, itemPrice);
            cart.addItem(item);
        }
        scanner.close();
        System.out.println("Total price: " + cart.getTotalPrice());
    }
}
