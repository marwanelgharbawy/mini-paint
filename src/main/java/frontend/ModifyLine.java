package frontend;

import javax.swing.*;

import backend.Validations;
import frontend.PaintingPanel;
import shapes.LineSegment;

import java.util.Map;

public class ModifyLine extends JFrame {
    private JPanel contentPane;
    private JTextField startX;
    private JTextField startY;
    private JTextField endX;
    private JTextField endY;
    private JButton repositionButton;
    private JButton backButton;

    public ModifyLine(LineSegment line, PaintingPanel canvas) {
        setContentPane(contentPane);
        setTitle("Modify Line");
        setSize(320, 240);
        setVisible(true);

        repositionButton.addActionListener(e -> {
            if (!Validations.isNumberValid(startX.getText()) || !Validations.isNumberValid(startY.getText())
                    || !Validations.isNumberValid(endX.getText()) || !Validations.isNumberValid(endY.getText())) {
                JOptionPane.showMessageDialog(null, "Please enter valid coordinates.");
                return;
            }

            double x1 = Double.parseDouble(startX.getText());
            double y1 = Double.parseDouble(startY.getText());
            double x2 = Double.parseDouble(endX.getText());
            double y2 = Double.parseDouble(endY.getText());
            line.setProperties(Map.of("startX", x1, "startY", y1, "endX", x2, "endY", y2));
            canvas.repaint();
            dispose();
        });
    }
}
