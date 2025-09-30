import java.util.ArrayList;
import java.util.List;

public class Character {
    private final int maxHealth;
    private int currentHealth;
    private final String name;

    private static List<Character> allCharacters = new ArrayList<>();

    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;

        allCharacters.add(this);
    }

    public static String printStatus() {
        if (allCharacters.size() == 0) {
            return "------------------------------------------\n" +
                    "Nobody's fighting right now !\n" +
                    "------------------------------------------\n";
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : allCharacters) {
            sb.append(c.toString()).append("\n");
        }
        return "------------------------------------------\n" +
                "Characters currently fighting :\n" + sb.toString() +
                "------------------------------------------\n";
    }

    public static Character fight(Character c1, Character c2) {
        while (c1.getCurrentHealth() > 0 && c2.getCurrentHealth() > 0) {
            c1.attack(c2);
            if (c2.getCurrentHealth() <= 0) {
                return c1;
            }

            c2.attack(c1);
            if (c1.getCurrentHealth() <= 0) {
                return c2;
            }
        }
        return null;
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

    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth <= 0) {
            currentHealth = 0;
        }
    }

    public void attack(Character target) {
        target.takeDamage(9);
    }
}
