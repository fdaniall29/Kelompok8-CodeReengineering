package Wide_Hierarchy;

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

package Wide_Hierarchy;

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

package Wide_Hierarchy.Pokemons;

import Wide_Hierarchy.Entity;
import Wide_Hierarchy.Move;
import Wide_Hierarchy.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Mudkip extends Pokemon {
    public Mudkip(String name) {
        super(name, 100);
        initializeMoveSet();
    }

    private void initializeMoveSet() {
        Move tackle = new Move("Tackle", 10, 0.9f, "Normal");
        Move waterGun = new Move("Water Gun", 20, 0.8f, "Water");

        List<Move> moveSet = new ArrayList<>();
        moveSet.add(tackle);
        moveSet.add(waterGun);

        setMoveSet(moveSet);
    }
}

package Wide_Hierarchy.Pokemons;

import Wide_Hierarchy.Entity;
import Wide_Hierarchy.Move;
import Wide_Hierarchy.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Treecko extends Pokemon {
    public Treecko(String name) {
        super(name, 100);
        initializeMoveSet();
    }

    private void initializeMoveSet() {
        Move pound = new Move("Pound", 10, 0.9f, "Normal");
        Move bulletSeed = new Move("Bullet Seed", 20, 0.8f, "Grass");

        List<Move> moveSet = new ArrayList<>();
        moveSet.add(pound);
        moveSet.add(bulletSeed);

        setMoveSet(moveSet);
    }
}

package Wide_Hierarchy;

import java.util.List;

public class Pokemon extends Entity {
    private int health;
    private List<Move> moveSet;

    public Pokemon(String name, int health) {
        super(name, "");
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<Move> getMoveSet() {
        return moveSet;
    }

    public void setMoveSet(List<Move> moveSet) {
        this.moveSet = moveSet;
    }

    public void attack(Pokemon target, Move move) {
        int damage = move.getDamage();
        target.takeDamage(damage);
    }

    public void takeDamage(int damage) {
        health -= damage;
    }
}

public class App {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Pokemon bob = new Mudkip("Bob");
        Pokemon geck = new Treecko("Geck");

        System.out.println(bob.getName() + " " + bob.getHealth());
        System.out.println(geck.getName() + " " + geck.getHealth());

        bob.attack(geck, bob.getMoveSet().get(0));

        System.out.println(bob.getName() + " " + bob.getHealth());
        System.out.println(geck.getName() + " " + geck.getHealth());
    }
}
