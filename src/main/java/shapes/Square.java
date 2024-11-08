package shapes;

import java.util.Map;

public class Square extends Rectangle {
    private double sideLength;

    public Square() {
        super();
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        double side = properties.get("side");
        super.setProperties(Map.of("width", side, "height", side));
    }

    @Override
    public Map<String, Double> getProperties() {
        double side = super.getProperties().get("width");
        return Map.of("side", side);
    }
}