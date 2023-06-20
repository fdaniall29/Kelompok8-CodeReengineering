package Missing_Hierarchy;

import Missing_Hierarchy.Pokemons.Charmander;
import Missing_Hierarchy.Pokemons.Mudkip;
import Missing_Hierarchy.Pokemons.Treecko;

public class App {
    public static void main(String[] args) {
        Test();
    }

    private static void Test(){
        Mudkip bob = new Mudkip("Bob");
        Charmander geck = new Charmander("Geck");

        System.out.println(bob.getName() + " " + bob.getHealth());
        System.out.println(geck.getName() + " " + geck.getHealth());

        bob.Attack(geck, bob.getMoveSet().get(0));

        System.out.println(bob.getName() + " " + bob.getHealth());
        System.out.println(geck.getName() + " " + geck.getHealth());
    }
}


package Missing_Hierarchy;

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

package Missing_Hierarchy;

public class Move extends Entity{
    private int damage;
    private float accuracy;
    private String typeName;

    public Move(String name, int damage, int accuracy,
                String typeName) {
        super(name, "");
        this.damage = damage;
        this.accuracy = accuracy;
        this.typeName = typeName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}