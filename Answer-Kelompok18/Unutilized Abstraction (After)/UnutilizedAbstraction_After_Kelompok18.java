class Main {
    public static void main(String[] args) {
        Sedan partSedan = new Sedan();
        partSedan.type();
        partSedan.parkingSensor();
        partSedan.turbo();
        partSedan.headLamps();
    }
}

abstract class Car {
    public void type() {
        System.out.println("stock");
    }

    abstract void parkingSensor();

    abstract void turbo();

    abstract void headLamps();
}

class Sedan extends Car {
    public void parkingSensor() {
        System.out.println("installed");
    }

    public void turbo() {
        System.out.println("not installed");
    }

    public void headLamps() {
        System.out.println("installed");
    }
}
