package frontend;

import shapes.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class AddCircle extends JFrame {
    private JPanel panel1;
    private JTextField xField;
    private JTextField yField;
    private JTextField radiusField;
    private JButton backButton;
    private JButton addButton;

    public AddCircle(PaintingPanel paintingPanel) {
        setContentPane(panel1);
        setTitle("Add Circle");
        setSize(320, 240);
        setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x = Double.parseDouble(xField.getText());
                double y = Double.parseDouble(yField.getText());
                double radius = Double.parseDouble(radiusField.getText());
                Circle circle = new Circle();
                circle.setPosition(new Point((int) x, (int) y));
                circle.setProperties(Map.of("radius", radius));
                paintingPanel.addShape(circle);
                dispose();
            }
        });
    }
}
