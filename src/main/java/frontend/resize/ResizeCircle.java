package frontend.resize;

import javax.swing.*;

import backend.Validations;
import frontend.PaintingPanel;
import shapes.Circle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ResizeCircle extends JFrame {

    private JPanel contentPane;
    private JButton resizeButton;
    private JTextField radiusField;
    private JButton backButton;

    public ResizeCircle(Circle circle, PaintingPanel canvas) {
        setContentPane(contentPane);
        setTitle("Resize Circle");
        setSize(320, 240);
        setVisible(true);

        resizeButton.addActionListener(e -> {
            if (!Validations.isNumberValid(radiusField.getText())) {
                JOptionPane.showMessageDialog(null, "Please enter a valid radius.");
                return;
            }

            double radius = Double.parseDouble(radiusField.getText());
            circle.setProperties(Map.of("radius", radius));
            canvas.repaint();
            dispose();
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
