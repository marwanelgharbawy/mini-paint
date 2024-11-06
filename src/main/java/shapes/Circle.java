package shapes;

import java.awt.*;
import java.util.Map;

public class Circle implements Shape {
    private Point position;
    private Color color;
    private Color fillColor;
    private int radius;

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
        
    }

    @Override
    public Map<String, Double> getProperties() {
        return Map.of();
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
        canvas.drawOval(position.x, position.y, radius/2, radius/2);
    }
}