package frontend;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private JButton circleButton;
    private JButton lineSegmentButton;
    private JButton squareButton;
    private JButton rectangleButton;
    private JComboBox shapeDropDown;
    private JButton colorizeButton;
    private JButton deleteButton;
    private JPanel contentPane;

    public MainWindow() {
        // Initialization
        setTitle("Vector Drawing Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //
        setContentPane(contentPane);
        setVisible(true);
        PaintingPanel canvas = new PaintingPanel();
        contentPane.add(canvas);
        canvas.setVisible(true);
        setSize(800,600);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
    }
}
