package frontend;

import frontend.PaintingPanel;
import shapes.Shape;
import backend.Validations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class MoveShape extends JFrame {
    private JTextField xFrield;
    private JTextField yField;
    private JButton backButton;
    private JButton moveButton;
    private JPanel contentPane;

    public MoveShape(Shape shape, PaintingPanel canvas) {
        setContentPane(contentPane);
        setTitle("Move Shape");
        setSize(320, 240);
        setVisible(true);

        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Validations.isNumberValid(xFrield.getText()) || !Validations.isNumberValid(yField.getText())) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid position.");
                    return;
                }

                double x = Double.parseDouble(xFrield.getText());
                double y = Double.parseDouble(yField.getText());
                shape.setProperties(Map.of("X", x, "Y", y));
                canvas.repaint();
                dispose();
            }
        });
    }
}
