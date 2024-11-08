package shapes;

import java.awt.*;
import java.util.Map;

public class LineSegment implements Shape {
    private Point startPoint;
    private Point endPoint;
    private Color color;

    public LineSegment() {
        this.startPoint = new Point(0, 0);
        this.endPoint = new Point(0, 0);
        this.color = Color.BLACK;
    }

    @Override
    public void setPosition(Point position) {
        this.startPoint = position;
    }

    @Override
    public Point getPosition() {
        return startPoint;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        double x1 = properties.get("startX");
        double y1 = properties.get("startY");
        double x2 = properties.get("endX");
        double y2 = properties.get("endY");
        this.startPoint = new Point((int) x1, (int) y1);
        this.endPoint = new Point((int) x2, (int) y2);
    }

    @Override
    public Map<String, Double> getProperties() {
        return Map.of("startX", (double) startPoint.x, "startY", (double) startPoint.y, "endX", (double) endPoint.x, "endY", (double) endPoint.y);
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
        // Can't be filled, will set the color of the line instead
        setColor(color);
    }

    @Override
    public Color getFillColor() {
        // Can't be filled, will return the color of the line instead
        return getColor();
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.color != null ? this.color : Color.BLACK);
        canvas.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }
}
