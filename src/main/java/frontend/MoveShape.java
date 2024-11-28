package frontend;

import shapes.AbstractShape;
import backend.Validations;
import shapes.LineSegment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class MoveShape extends JFrame {
    private JTextField xField;
    private JTextField yField;
    private JButton backButton;
    private JButton moveButton;
    private JPanel contentPane;

    public MoveShape(AbstractShape shape, PaintingPanel canvas) {
        setContentPane(contentPane);
        setTitle("Move Shape");
        setSize(320, 240);
        setVisible(true);

        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Validations.isNumberValid(xField.getText()) || !Validations.isNumberValid(yField.getText())) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid position.");
                    return;
                }

                double x = Double.parseDouble(xField.getText());
                double y = Double.parseDouble(yField.getText());
                Utilities.warnIfOutOfBorder(x, y);

                // Special case for line segment: we need to update the end point as well
                if (shape instanceof LineSegment) {
                    LineSegment line = (LineSegment) shape;
                    // Update the end point of the line:
                    // new endX = old endX + (new startX - old startX) = old endX + dx
                    double dx = x - line.getProperties().get("startX");
                    double dy = y - line.getProperties().get("startY");
                    line.setProperties(Map.of("startX", x, "startY", y, "endX", line.getProperties().get("endX") + dx, "endY", line.getProperties().get("endY") + dy));
                }
                else { // For all other shapes
                    shape.setProperties(Map.of("X", x, "Y", y));
                }
                canvas.repaint();
                dispose();
            }
        });
    }
}
