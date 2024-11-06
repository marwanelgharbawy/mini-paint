package frontend;

import javax.swing.*;

public class MainWindow extends JFrame {
    private PaintingPanel canvas;
    private JButton circleButton;
    private JButton lineSegmentButton;
    private JButton squareButton;
    private JButton rectangleButton;
    private JComboBox shapeDropDown;
    private JButton colorizeButton;
    private JButton deleteButton;
    private JPanel contentPane;

    public MainWindow() {
        setContentPane(contentPane);
        pack();
        setVisible(true);
        PaintingPanel canvas = new PaintingPanel();
        add(canvas);
        canvas.setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
    }
}
