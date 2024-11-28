package shapes;

import java.awt.*;
import java.util.Map;

public abstract class AbstractShape implements ShapeInterface {
    protected Point position;
    protected Color color;
    protected Color fillColor;
    protected int id;

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return this.position;
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

    public abstract void setProperties(Map<String, Double> properties);
    public abstract Map<String, Double> getProperties();
    public abstract void draw(Graphics canvas);
}
