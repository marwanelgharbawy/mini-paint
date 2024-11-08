package shapes;

import java.awt.*;
import java.util.Map;

public class Rectangle implements Shape {
    private Point position;
    private Color color;
    private Color fillColor;
    private double height;
    private double width;
    protected int id;
    private static int rectangleCounter = 0;

    public Rectangle() {
        this.position = new Point(0, 0);
        this.height = 0;
        this.width = 0;
        this.color = null;
        this.fillColor = null;
        this.id = rectangleCounter++;
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
    public void setProperties(Map<String, Double> properties) { // Width and height
        this.width = properties.get("width");
        this.height = properties.get("height");
    }

    @Override
    public Map<String, Double> getProperties() {
        return Map.of("width", (double) width, "height", (double) height);
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
    public void draw(Graphics g) {
        // We have 2 colors, color and fill color
        g.setColor(this.color != null ? this.color : Color.BLACK); // If color is null, use black as outline
        g.drawRect(position.x, position.y, (int) width, (int) height); // Draw rectangle
        if (this.fillColor != null) {
            g.setColor(this.fillColor);
            g.fillRect(position.x, position.y, (int) width, (int) height); // Fill rectangle
        }
    }

    @Override
    public String toString() {
        return "rectangle" + id;
    }
}