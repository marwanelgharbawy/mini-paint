package frontend;

import backend.GraphicsEngine;

import javax.swing.*;
import java.awt.*;

public class PaintingPanel extends JPanel {
    private GraphicsEngine graphicsEngine;
    private Graphics canvas;

    public PaintingPanel() {
        graphicsEngine = new GraphicsEngine();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (graphicsEngine != null) {
            graphicsEngine.refresh(canvas);
        }
    }
}