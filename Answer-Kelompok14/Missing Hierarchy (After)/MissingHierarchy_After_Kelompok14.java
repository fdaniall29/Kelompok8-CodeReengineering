public class Entity {
    private String name;
    private String sprite;

    public Entity(String name, String sprite) {
        this.name = name;
        this.sprite = sprite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }
}

public class Pokemon extends Entity {
    private int health;

    public Pokemon(String name, String sprite, int health) {
        super(name, sprite);
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void attack(Pokemon target, Move move) {
        int damage = move.getDamage();
        target.takeDamage(damage);
    }

    public void takeDamage(int damage) {
        health -= damage;
    }
}

public class Move {
    private String name;
    private int damage;
    private float accuracy;
    private String typeName;

    public Move(String name, int damage, float accuracy, String typeName) {
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
        this.typeName = typeName;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public String getTypeName() {
        return typeName;
    }
}

public class App {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Pokemon mudkip = new Pokemon("Mudkip", "", 100);
        Pokemon charmander = new Pokemon("Charmander", "", 100);

        System.out.println(mudkip.getName() + " " + mudkip.getHealth());
        System.out.println(charmander.getName() + " " + charmander.getHealth());

        mudkip.attack(charmander, new Move("Water Gun", 20, 1.0f, "Water"));

        System.out.println(mudkip.getName() + " " + mudkip.getHealth());
        System.out.println(charmander.getName() + " " + charmander.getHealth());
    }
}