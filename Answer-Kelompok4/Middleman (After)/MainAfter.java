public class Main {

    public static void main(String[] args) {
        System.out.println("What weapon is the warrior using");

        Warrior warrior1 = new Warrior("Swordsman", new Weapon("Sword", "Longsword"));

        warrior1.getWeapon().weapontype();
    }
}

class Warrior {
    private String type;
    private Weapon weapon;

    public Warrior(String type, Weapon weapon) {
        this.type = type;
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}

class Weapon {
    private String name;
    private String type;

    public Weapon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void weapontype() {
        System.out.println("Weapon: " + name);
        System.out.println("Type: " + type);
    }
}
