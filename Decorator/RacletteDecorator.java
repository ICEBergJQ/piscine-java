public abstract class RacletteDecorator implements Raclette {
    protected Raclette raclette;

    public RacletteDecorator(Raclette raclette) {
        this.raclette = raclette;
    }

    public int getCalories() {
        return raclette.getCalories();
    }

    public String getIngredients() {
        return raclette.getIngredients();
    }

    public String toString() {
        return getIngredients() + " pour " + getCalories() + " calories";
    }
}
