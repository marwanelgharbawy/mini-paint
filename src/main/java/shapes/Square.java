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
        if (properties.get("side") != null) {
            super.setProperties(Map.of("width", properties.get("side"), "height", properties.get("side")));
        }
        if (properties.get("X") != null && properties.get("Y") != null) {
            super.setProperties(Map.of("X", properties.get("X"), "Y", properties.get("Y")));
        }
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