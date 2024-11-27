package shapes;

import java.util.Map;

public class Square extends Rectangle {
    private static int squareCounter = 0;

    public Square() {
        super();
        this.id = squareCounter++;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        double side = properties.get("side");
        super.setProperties(Map.of("width", side, "height", side));
    }

    @Override
    public Map<String, Double> getProperties() {
        double side = super.getProperties().get("width"); // Both width and height are the same
        return Map.of("side", side);
    }

    @Override
    public String toString() {
        return "Square" + id;
    }
}