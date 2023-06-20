public class Warrior {
    private String name;
    private Weapon weapon;

    public Warrior(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}

class Weapon {
    private String type;

    public Weapon(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
