package shapes;

import java.awt.*;
import java.util.Map;

public class Rectangle implements Shape {
    private Point position;
    private Color color;
    private Color fillColor;
    private double height;
    private double width;

    public Rectangle() {
        this.position = new Point(0, 0);
        this.height = 0;
        this.width = 0;
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
    public void setProperties(Map<String, Double> properties) { // Width and height
        this.width = properties.get("width").doubleValue();
        this.height = properties.get("height").doubleValue();
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
//        int[] xPoints = {position.x, position.x, position.x + width / 2, position.x + width / 2};
//        int[] yPoints = {position.y, position.y, position.y + width / 2, position.y + width / 2};
//        g.setColor(this.color != null ? this.color : Color.BLACK);
//        g.drawPolygon(xPoints, yPoints, 4);
        g.setColor(this.color != null ? this.color : Color.BLACK);
//        g.fillRect(position.x, position.y, 100, 50); // Example rectangle
        g.fillRect(position.x, position.y, (int) width, (int) height);
    }
}