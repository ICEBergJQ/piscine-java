public class WithColdMeats extends RacletteDecorator {
    public WithColdMeats(Raclette raclette) {
        super(raclette);
    }

    public int getCalories() {
        return raclette.getCalories() + 350;
    }

    public String getIngredients() {
        return raclette.getIngredients() + ", charcuterie";
    }
}
