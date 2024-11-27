package shapes;

import java.awt.*;
import java.util.Map;

public class Rectangle extends Shape {
    protected double height;
    protected double width;
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
    public void setProperties(Map<String, Double> properties) { // Width and height
        this.width = properties.get("width");
        this.height = properties.get("height");
    }

    @Override
    public Map<String, Double> getProperties() {
        return Map.of("width", (double) width, "height", (double) height);
    }

    @Override
    public void draw(Graphics canvas) {
        // We have 2 colors, color and fill color
        canvas.setColor(this.color != null ? this.color : Color.BLACK); // If color is null, use black as outline
        canvas.drawRect(position.x, position.y, (int) width, (int) height); // Draw rectangle
        if (this.fillColor != null) {
            canvas.setColor(this.fillColor);
            canvas.fillRect(position.x, position.y, (int) width, (int) height); // Fill rectangle
        }
    }

    @Override
    public String toString() {
        return "rectangle" + id;
    }
}