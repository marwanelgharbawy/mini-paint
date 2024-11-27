package shapes;

import java.awt.*;
import java.util.Map;

public interface ShapeInterface {
    // Set position
    public void setPosition(Point position);
    public Point getPosition();

    // Update shape-specific properties, (e.g., radius)
    public void setProperties(Map<String, Double> properties);
    public Map<String, Double> getProperties();

    // Colorize
    public void setColor(Color color);
    public Color getColor();
    public void setFillColor(Color color);
    public Color getFillColor();

    // Redraw the shape on the canvas
    public void draw(Graphics canvas);
}