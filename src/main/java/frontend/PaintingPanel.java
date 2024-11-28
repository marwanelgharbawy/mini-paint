package frontend;

import backend.GraphicsEngine;
import shapes.AbstractShape;

import javax.swing.*;
import java.awt.*;

public class PaintingPanel extends JPanel {
    private GraphicsEngine graphicsEngine;
    private Graphics canvas;

    public PaintingPanel() {
        graphicsEngine = new GraphicsEngine();
    }

    public void addShape(AbstractShape shape) {
        graphicsEngine.addShape(shape);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (graphicsEngine != null) {
            graphicsEngine.refresh(g);
        }
    }

    public GraphicsEngine getGraphicsEngine() {
        return graphicsEngine;
    }
}