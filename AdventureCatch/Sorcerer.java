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
    public void heal(Character character) throws DeadCharacterException {
        if (this.getCurrentHealth() <= 0) {
            throw new DeadCharacterException(this);
        }
        int newHealth = character.getCurrentHealth() + healCapacity;
        character.setCurrentHealth(Math.min(newHealth, character.getMaxHealth()));
    }

    @Override
    public void attack(Character character) throws DeadCharacterException {
        if (this.getCurrentHealth() <= 0) {
            throw new DeadCharacterException(this);
        }
        int damage = (getWeapon() != null) ? getWeapon().getDamage() : 7;
        character.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (this.getCurrentHealth() <= 0) {
            throw new DeadCharacterException(this);
        }
        int reducedDamage = (int) Math.floor(damage * 0.8);
        setCurrentHealth(Math.max(0, getCurrentHealth() - reducedDamage));
    }

    @Override
    public String toString() {
        String base = (getCurrentHealth() == 0)
                ? getName() + " is a dead sorcerer. So bad, it could heal " + healCapacity + " HP."
                : getName() + " is a sorcerer with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP.";
        return base + (getWeapon() != null ? " He has the weapon " + getWeapon().toString() : "");
    }
}
