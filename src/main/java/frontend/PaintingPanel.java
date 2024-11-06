package frontend;

import backend.GraphicsEngine;

import javax.swing.*;
import java.awt.*;

public class PaintingPanel extends JPanel {
    private GraphicsEngine graphicsEngine;
    private Graphics canvas;

    public PaintingPanel() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graphicsEngine.refresh(canvas);
    }

}
