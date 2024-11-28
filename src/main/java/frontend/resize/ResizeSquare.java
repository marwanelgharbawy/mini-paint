package frontend.resize;

import javax.swing.*;

import backend.Validations;
import frontend.PaintingPanel;
import shapes.Square;

import java.util.Map;

public class ResizeSquare extends JFrame {
    private JPanel contentPane;
    private JTextField sideField;
    private JButton resizeButton;
    private JButton backButton;

    public ResizeSquare(Square square, PaintingPanel canvas) {
        setContentPane(contentPane);
        setTitle("Resize Square");
        setSize(320, 240);
        setVisible(true);

        resizeButton.addActionListener(e -> {
            if (!Validations.isNumberValid(sideField.getText())) {
                JOptionPane.showMessageDialog(null, "Please enter a valid side length.");
                return;
            }

            double side = Double.parseDouble(sideField.getText());
            square.setProperties(Map.of("side", side));
            canvas.repaint();
            dispose();
        });
    }
}
