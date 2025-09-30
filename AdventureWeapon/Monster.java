public class Monster extends Character {
    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    @Override
    public void attack(Character character) {
        int damage = (getWeapon() != null) ? getWeapon().getDamage() : 7;
        character.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        int reducedDamage = (int) Math.floor(damage * 0.8);
        setCurrentHealth(Math.max(0, getCurrentHealth() - reducedDamage));
    }

    @Override
    public String toString() {
        String base = (getCurrentHealth() == 0)
            ? getName() + " is a monster and is dead."
            : getName() + " is a monster with " + getCurrentHealth() + " HP.";
        return base + (getWeapon() != null ? " He has the weapon " + getWeapon().toString() : "");
    }
}
