package backend;

import shapes.AbstractShape;

import java.awt.Graphics;

public interface DrawingEngine {
    // Manage shapes objects
    public void addShape(AbstractShape shape);
    public void removeShape(AbstractShape shape);

    // Return the created shape objects
    public AbstractShape[] getShapes();

    // Redraw all shapes on the canvas
    public void refresh(Graphics canvas);
}