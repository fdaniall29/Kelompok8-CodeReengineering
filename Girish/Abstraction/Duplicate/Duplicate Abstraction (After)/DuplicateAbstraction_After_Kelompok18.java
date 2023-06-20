public class Main {
    public static void main(String[] args) {
        Mercedes mercedes = new Mercedes();
        Ducati ducati = new Ducati();

        mercedes.stock();
        mercedes.model();
        mercedes.color();
        System.out.println();

        ducati.stock();
        ducati.model();
        ducati.color();
        ducati.cylinderCapacity();
    }
}

abstract class Vehicle {
    abstract void model();
    abstract void color();
    public void stock() {
        System.out.println("available");
    }
}

abstract class Motorcycle extends Vehicle {
    abstract void cylinderCapacity();
}

class Mercedes extends Vehicle {
    public void model() {
        System.out.println("e320");
    }
    public void color() {
        System.out.println("silver");
    }
}

class Ducati extends Motorcycle {
    public void model() {
        System.out.println("v4S");
    }
    public void color() {
        System.out.println("red");
    }
    public void cylinderCapacity() {
        System.out.println("1103cc");
    }
}
