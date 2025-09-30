import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private Weapon weapon;

    private static List<Character> allCharacters = new ArrayList<>();

    public Character(String name, int maxHealth, Weapon weapon) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.weapon = weapon;
        this.currentHealth = maxHealth;
        allCharacters.add(this);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public static String printStatus() {
        if (allCharacters.size() == 0) {
            return "------------------------------------------\n" +
                    "Nobody's fighting right now !\n" +
                    "------------------------------------------\n";
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : allCharacters) {
            sb.append(" - " + c.toString()).append("\n");
        }
        return "------------------------------------------\n" +
                "Characters currently fighting :\n" + sb.toString() +
                "------------------------------------------\n";
    }

    public static Character fight(Character c1, Character c2) {
        while (c1.getCurrentHealth() > 0 && c2.getCurrentHealth() > 0) {
            try {
                c1.attack(c2);
            } catch (DeadCharacterException e) {
                System.out.println(e.getMessage());
                break;
            }

            if (c2.getCurrentHealth() <= 0)
                break;

            try {
                c2.attack(c1);
            } catch (DeadCharacterException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        return (c1.getCurrentHealth() > 0) ? c1 : c2;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public String toString() {
        if (currentHealth == 0) {
            return name + " : KO";
        }
        return name + " : " + currentHealth + "/" + maxHealth;
    }

    protected void setCurrentHealth(int health) {
        this.currentHealth = health;
    }

    public abstract void attack(Character character) throws DeadCharacterException;

    public abstract void takeDamage(int damage) throws DeadCharacterException;

}
