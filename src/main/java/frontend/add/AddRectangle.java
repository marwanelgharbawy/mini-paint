package frontend.add;

import frontend.MainWindow;
import frontend.PaintingPanel;
import frontend.Utilities;
import shapes.Rectangle;
import backend.Validations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class AddRectangle extends JFrame {
    private JPanel contentPane;
    private JTextField xField;
    private JTextField yField;
    private JTextField widthField;
    private JTextField heightField;
    private JButton backButton;
    private JButton addButton;

    public AddRectangle(PaintingPanel paintingPanel, MainWindow mainWindow) {
        setContentPane(contentPane);
        setTitle("Add Rectangle");
        setSize(320, 240);
        setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!Validations.isNumberValid(xField.getText()) || !Validations.isNumberValid(yField.getText())) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid position.");
                    return;
                }

                if (!Validations.isNumberValid(widthField.getText()) || !Validations.isNumberValid(heightField.getText())) {
                    JOptionPane.showMessageDialog(null, "Please enter valid dimensions.");
                    return;
                }

                double x = Double.parseDouble(xField.getText());
                double y = Double.parseDouble(yField.getText());
                double width = Double.parseDouble(widthField.getText());
                double height = Double.parseDouble(heightField.getText());

                Utilities.warnIfOutOfBorder(x, y, width, height);

                Rectangle rectangle = new Rectangle();
                rectangle.setProperties(Map.of("width", width, "height", height, "X", x, "Y", y));
                paintingPanel.addShape(rectangle);

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
