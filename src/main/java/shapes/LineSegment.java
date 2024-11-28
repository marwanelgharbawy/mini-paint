package shapes;

import java.awt.*;
import java.util.Map;

public class LineSegment extends AbstractShape {
    private Point endPoint;
    private static int lineCounter = 0;

    public LineSegment() {
        this.position = new Point(0, 0);
        this.endPoint = new Point(0, 0);
        this.color = null;
        this.id = lineCounter++;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        double x1 = properties.get("startX");
        double y1 = properties.get("startY");
        double x2 = properties.get("endX");
        double y2 = properties.get("endY");
        this.position = new Point((int) x1, (int) y1);
        this.endPoint = new Point((int) x2, (int) y2);
    }

    @Override
    public Map<String, Double> getProperties() {
        return Map.of("startX", (double) position.x, "startY", (double) position.y, "endX", (double) endPoint.x, "endY", (double) endPoint.y);
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
        canvas.drawLine(position.x, position.y, endPoint.x, endPoint.y);
    }

    @Override
    public String toString() {
        return "line" + id;
    }
}
