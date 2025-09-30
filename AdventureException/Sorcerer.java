public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character character) {
        int newHealth = character.getCurrentHealth() + healCapacity;
        character.setCurrentHealth(Math.min(newHealth, character.getMaxHealth()));
    }

    @Override
    public void attack(Character character) {
        heal(this);
        int damage = (getWeapon() != null) ? getWeapon().getDamage() : 10;
        character.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        setCurrentHealth(Math.max(0, getCurrentHealth() - damage));
    }

    @Override
    public String toString() {
        String base = (getCurrentHealth() == 0)
            ? getName() + " is a dead sorcerer. So bad, it could heal " + healCapacity + " HP."
            : getName() + " is a sorcerer with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP.";
        return base + (getWeapon() != null ? " He has the weapon " + getWeapon().toString() : "");
    }
}
