public class Company {
    private double revenues;
    private double expenses;
    private PersonalTaxCalculator taxCalculator;

    public Company(double revenues, double expenses) {
        this.revenues = revenues;
        this.expenses = expenses;
        this.taxCalculator = new PersonalTaxCalculator();
    }

    public double getIncome() {
        return revenues - expenses;
    }

    public double calculateTax(double income, double taxRate) {
        return taxCalculator.calculateTax(income, taxRate);
    }
}
