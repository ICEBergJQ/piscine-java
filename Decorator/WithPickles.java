public class WithPickles extends RacletteDecorator {
    public WithPickles(Raclette raclette) {
        super(raclette);
    }

    public int getCalories() {
        return raclette.getCalories() + 50;
    }

    public String getIngredients() {
        return raclette.getIngredients() + ", cornichons";
    }
}
