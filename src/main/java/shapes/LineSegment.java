package shapes;

import java.awt.*;
import java.util.Map;

public class LineSegment implements Shape {
    private Point startPoint;
    private Point endPoint;
    private Color color;

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
        // Can't be filled, should never be used
    }

    @Override
    public Color getFillColor() {
        // Can't be filled, should never be used
        return null;
    }

    @Override
    public void draw(Graphics canvas) {
        canvas.setColor(this.color != null ? this.color : Color.BLACK);
        canvas.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
    }
}
