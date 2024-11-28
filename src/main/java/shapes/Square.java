package shapes;

import java.util.HashMap;
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
        if (properties.get("color") != null) {
            super.setProperties(Map.of("color", properties.get("color")));
        }
        if (properties.get("fillColor") != null) {
            super.setProperties(Map.of("fillColor", properties.get("fillColor")));
        }
    }

    @Override
    public Map<String, Double> getProperties() {
        Map<String, Double> properties = super.getProperties();
        properties.put("side", width);
        properties.remove("width");
        properties.remove("height");
        return properties;
    }

    @Override
    public String toString() {
        return "Square" + id;
    }
}