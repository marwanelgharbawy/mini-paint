package backend;

import shapes.Shape;

import java.awt.*;
import java.util.ArrayList;

public class GraphicsEngine implements DrawingEngine {
    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    @Override
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public Shape[] getShapes() {
        return shapes.toArray(new Shape[0]);
    }

    @Override
    public void refresh(Graphics canvas) {
        for (Shape shape : shapes) {
            shape.draw(canvas);
        }
    }
}
