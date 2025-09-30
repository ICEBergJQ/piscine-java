public class Monster extends Character {

    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    @Override
    public void attack(Character character) {
        character.takeDamage(7);
    }

    @Override
    public void takeDamage(int damage) {
        int reducedDamage = (int) Math.floor(damage * 0.8);
        setCurrentHealth(Math.max(0, getCurrentHealth() - reducedDamage));
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " is a monster and is dead.";
        } else {
            return getName() + " is a monster with " + getCurrentHealth() + " HP.";
        }
    }
}
