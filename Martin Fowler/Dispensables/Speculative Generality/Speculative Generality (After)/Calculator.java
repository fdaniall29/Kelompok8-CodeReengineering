public class Calculator {
    // Mengubah metode calculate untuk mengambil char sebagai operator daripada String
    public static double calculate(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            case '%':
                return num1 % num2;
            default:
                throw new IllegalArgumentException("Invalid operator!");
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(calculate(10, 5, '+')); // output: 15.0
            System.out.println(calculate(10, 5, '-')); // output: 5.0
            System.out.println(calculate(10, 5, '*')); // output: 50.0
            System.out.println(calculate(10, 5, '/')); // output: 2.0
            System.out.println(calculate(10, 5, '%')); // output: 0.0
            System.out.println(calculate(10, 5, '$')); // output: Invalid operator!
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
