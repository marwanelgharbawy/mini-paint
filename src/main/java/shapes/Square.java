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
        double x = properties.get("X");
        double y = properties.get("Y");
        super.setProperties(Map.of("width", side, "height", side, "X", x, "Y", y));
    }

    @Override
    public Map<String, Double> getProperties() {
        double side = super.getProperties().get("width"); // Both width and height are the same
        int x = super.getPosition().x;
        int y = super.getPosition().y;
        return Map.of("side", side, "X", (double) x, "Y", (double) y);
    }

    @Override
    public String toString() {
        return "Square" + id;
    }
}