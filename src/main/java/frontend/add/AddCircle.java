package frontend.add;

import frontend.MainWindow;
import frontend.PaintingPanel;
import shapes.Circle;
import backend.Validations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class AddCircle extends JFrame {
    private JPanel contentPane;
    private JTextField xField;
    private JTextField yField;
    private JTextField radiusField;
    private JButton backButton;
    private JButton addButton;

    public AddCircle(PaintingPanel paintingPanel, MainWindow mainWindow) {
        setContentPane(contentPane);
        setTitle("Add Circle");
        setSize(320, 240);
        setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!Validations.isNumberValid(xField.getText()) || !Validations.isNumberValid(yField.getText())) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid position.");
                    return;
                }

                if (!Validations.isNumberValid(radiusField.getText())) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid radius.");
                    return;
                }

                double x = Double.parseDouble(xField.getText());
                double y = Double.parseDouble(yField.getText());
                double radius = Double.parseDouble(radiusField.getText());

                Circle circle = new Circle();
                circle.setPosition(new Point((int) x, (int) y));
                circle.setProperties(Map.of("radius", radius));
                paintingPanel.addShape(circle);

                mainWindow.updateShapeDropDown();
                dispose();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
