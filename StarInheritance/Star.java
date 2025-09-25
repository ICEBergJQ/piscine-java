public class Star extends CelestialObject {
    private double magnitude;

    public Star() {
        super("Soleil", 0.0, 0.0, 0.0);
        this.magnitude = 0.0;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }
}
