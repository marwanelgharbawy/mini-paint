package shapes;

import java.awt.*;
import java.util.Map;

public class Rectangle implements Shape {
    private Point position;
    private int height;
    private int width;
    private Color color;
    private Color fillColor;

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
        int[] xPoints = {position.x, position.x, position.x + width / 2, position.x + width / 2};
        int[] yPoints = {position.y, position.y, position.y + width / 2, position.y + width / 2};
        canvas.setColor(this.color != null ? this.color : Color.BLACK);
        canvas.drawPolygon(xPoints, yPoints, 4);
    }
}