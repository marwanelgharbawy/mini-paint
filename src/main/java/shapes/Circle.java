package shapes;

import java.awt.*;
import java.util.Map;

public class Circle implements Shape {
    private Point position;
    private Color color;
    private Color fillColor;
    private double radius;

    public Circle() {
        this.position = new Point(0, 0);
        this.radius = 0;
        this.color = Color.BLACK;
        this.fillColor = Color.WHITE;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        this.radius = properties.get("radius");
    }

    @Override
    public Map<String, Double> getProperties() {
        return Map.of("radius", radius);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.color != null ? this.color : Color.BLACK);
        canvas.drawOval(position.x, position.y, (int) radius/2, (int) radius/2);
    }
}