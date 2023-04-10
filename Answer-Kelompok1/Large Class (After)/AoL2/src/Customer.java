public class Customer {
    private String name;
    private int age;
    private int credit;

    public Customer(String n, int a, int c) {
        name = n;
        age = a;
        credit = c;
    }

    public void setName(String n) {
        name = n;
    }

    public void setAge(int a) {
        age = a;
    }

    public void setCredit(int c) {
        credit = c;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getCredit() {
        return credit;
    }

    // Menyederhanakan metode hasCredit() menggunakan return langsung
    public boolean hasCredit() {
        return credit > 0;
    }

    // Menyederhanakan metode isAdult() menggunakan return langsung
    public boolean isAdult() {
        return age >= 18;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Credit: " + credit);
    }
}
