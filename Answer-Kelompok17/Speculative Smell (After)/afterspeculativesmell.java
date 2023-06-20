public interface Animal {

    void eat();

    void sleep();

}

public class Dog implements Animal {

    public void eat() {
        System.out.println("Dog is Eating");
    }

    public void sleep() {
        System.out.println("Zzzrzzzzrzz");
    }

    void bark() {
        System.out.println("Guguk");
    }

}

public class Snake implements Animal {

    public void eat() {
        System.out.println("Snake is Eating");
    }

    public void sleep() {
        System.out.println("Zzzszzzzszz");
    }

    void hiss() {
        System.out.println("hsssssssss");
    }

}