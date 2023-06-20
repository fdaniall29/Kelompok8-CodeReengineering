public class CurrencyConverter {
    private static final double EUR_CONVERSION_RATE = 0.9;
    private static final double IDR_CONVERSION_RATE = 15000;

    public static double convertToCurrency(double price, String currencyTo) {
        if (currencyTo.equalsIgnoreCase("EUR")) {
            return price * EUR_CONVERSION_RATE;
        } else if (currencyTo.equalsIgnoreCase("IDR")) {
            return price * IDR_CONVERSION_RATE;
        } else {
            throw new IllegalArgumentException("Unrecognized currency: " + currencyTo);
        }
    }
}