package backend;

import shapes.Shape;

import java.awt.Graphics;

public interface DrawingEngine {
    // Manage shapes objects
    public void addShape(Shape shape);
    public void removeShape(Shape shape);

    // Return the created shape objects
    public Shape[] getShapes();

    // Redraw all shapes on the canvas
    public void refresh(Graphics canvas);
}