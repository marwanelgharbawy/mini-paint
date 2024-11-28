package shapes;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Circle extends AbstractShape {
    private double radius;
    private static int circleCounter = 0;

    public Circle() {
        this.position = new Point(0, 0);
        this.color = null;
        this.fillColor = null;
        this.radius = 0;
        this.id = circleCounter++;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        if (properties.get("radius") != null) {
            this.radius = properties.get("radius");
        }
        super.setProperties(properties);
    }

    @Override
    public Map<String, Double> getProperties() {
        Map<String, Double> properties = new HashMap<>();
        properties.put("X", (double) position.x);
        properties.put("Y", (double) position.y);
        properties.put("radius", radius);
        if (color != null) {
            properties.put("color", (double) color.getRGB());
        }
        if (fillColor != null) {
            properties.put("fillColor", (double) fillColor.getRGB());
        }
        return properties;
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.color != null ? this.color : Color.BLACK);
        canvas.drawOval(position.x, position.y, (int) radius * 2, (int) radius * 2);
        if (this.fillColor != null) {
            canvas.setColor(this.fillColor);
            canvas.fillOval(position.x, position.y, (int) radius * 2, (int) radius * 2);
        }
    }

    @Override
    public String toString() {
        return "Circle" + id;
    }
}