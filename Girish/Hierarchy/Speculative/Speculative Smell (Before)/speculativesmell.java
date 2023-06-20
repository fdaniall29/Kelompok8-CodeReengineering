public interface Animal {

    void eat();

    void sleep();

}

public abstract class Mammal implements Animal {

    void giveBirth() {
        System.out.println("Baby Mammal is born!");
    }

}

public abstract class Reptile implements Animal {

    void layEggs() {
        System.out.println("Baby Reptile is born!");
    }

}

public class Dog extends Mammal {

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

public class Snake extends Reptile {

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