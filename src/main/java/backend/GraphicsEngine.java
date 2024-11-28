package backend;

import shapes.AbstractShape;

import java.awt.*;
import java.util.ArrayList;

public class GraphicsEngine implements DrawingEngine {
    private ArrayList<AbstractShape> shapes = new ArrayList<AbstractShape>();

    public GraphicsEngine() {
        shapes = new ArrayList<AbstractShape>();
    }

    @Override
    public void addShape(AbstractShape shape) {
        shapes.add(shape);
    }

    @Override
    public void removeShape(AbstractShape shape) {
        shapes.remove(shape);
    }

    @Override
    public AbstractShape[] getShapes() {
        return shapes.toArray(new AbstractShape[0]);
    }

    @Override
    public void refresh(Graphics canvas) {
        for (AbstractShape shape : shapes) {
            shape.draw(canvas);
        }
    }

    public void deleteAllShapes() {
        shapes.clear();
    }
}