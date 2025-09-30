public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
        this.shield = shield;
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
    public int getShield() {
        return shield;
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
                ? getName() + " has been beaten, even with its " + shield +
                        " shield. So bad, it could heal " + healCapacity + " HP."
                : getName() + " is a strong Templar with " + getCurrentHealth() +
                        " HP. It can heal " + healCapacity + " HP and has a shield of " + shield + ".";
        return base + (getWeapon() != null ? " He has the weapon " + getWeapon().toString() : "");
    }
}
