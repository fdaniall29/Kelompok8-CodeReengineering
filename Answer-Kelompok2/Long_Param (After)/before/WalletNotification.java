public class WalletNotification {
    public void balanceNotif(WalletTransaction transaction) {
        String message = switch (Integer.signum(transaction.getAmount())) {
            case 0 -> String.format("Halo %s, Saldo mu sekarang ada %2d ", transaction.getName(), transaction.getCurrent());
            case 1 -> String.format("Halo %s, ada %2d masuk ke akunmu nih. Sekarang balance-mu menjadi %2d", transaction.getName(), transaction.getAmount(), transaction.getCurrent());
            case -1 -> String.format("Halo %s, ada %2d keluar dari akunmu nih. Sekarang balance-mu menjadi %2d", transaction.getName(), -transaction.getAmount(), transaction.getCurrent());
            default -> "";
        };
        System.out.printf("Email terkirim ke %s\n", transaction.getEmail());
        System.out.println("Isi email: ");
        System.out.println(message);
    }
}

class WalletTransaction {
    private final String name;
    private final String email;
    private final int amount;
    private final int current;

    public WalletTransaction(String name, String email, int amount, int current) {
        this.name = name;
        this.email = email;
        this.amount = amount;
        this.current = current;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAmount() {
        return amount;
    }

    public int getCurrent() {
        return current;
    }
}
