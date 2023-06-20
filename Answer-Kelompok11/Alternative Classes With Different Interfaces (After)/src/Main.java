public class Main {
    public static void main(String[] args) {
        CheckoutHandler handler = new CheckoutHandler();

        handler.addItemToCart(new Item("Shirt", 25.0));
        handler.addItemToCart(new Item("Pants", 40.0));
        handler.addItemToCart(new Item("Hat", 15.0));

        printReceipt(handler);

        // Calculate total price in USD
        double totalPriceUSD = handler.calculateTotalPrice();
        System.out.println("Total price in USD: $" + String.format("%.2f", totalPriceUSD));

        // Convert total price to EUR
        double totalPriceEUR = CurrencyConverter.convertToCurrency(totalPriceUSD, "EUR");
        System.out.println("Total price in EUR: " + String.format("%.2f", totalPriceEUR));

        // Convert total price to IDR
        double totalPriceIDR = CurrencyConverter.convertToCurrency(totalPriceUSD, "IDR");
        System.out.println("Total price in IDR: Rp " + String.format("%.0f", totalPriceIDR));
    }

    public static void printReceipt(CheckoutHandler handler) {
        System.out.println("-------------------");
        System.out.println("      RECEIPT      ");
        System.out.println("-------------------");
        for (Item item : handler.getCart()) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("-------------------");
    }
}
