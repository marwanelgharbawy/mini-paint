package frontend.resize;

import javax.swing.*;

import backend.Validations;
import frontend.PaintingPanel;
import shapes.Rectangle;

import java.util.Map;

public class ResizeRectangle extends JFrame{
    private JPanel contentPane;
    private JTextField widthField;
    private JTextField heightField;
    private JButton resizeButton;
    private JButton backButton;

    public ResizeRectangle(Rectangle rectangle, PaintingPanel canvas) {
        setContentPane(contentPane);
        setTitle("Resize Rectangle");
        setSize(320, 240);
        setVisible(true);

        resizeButton.addActionListener(e -> {

            if (!Validations.isNumberValid(widthField.getText()) || !Validations.isNumberValid(heightField.getText())) {
                JOptionPane.showMessageDialog(null, "Please enter valid width and height.");
                return;
            }

            double width = Double.parseDouble(widthField.getText());
            double height = Double.parseDouble(heightField.getText());
            rectangle.setProperties(Map.of("width", width, "height", height));
            canvas.repaint();
            dispose();
        });
    }
}
