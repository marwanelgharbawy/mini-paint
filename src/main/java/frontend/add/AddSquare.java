package frontend.add;

import frontend.MainWindow;
import frontend.PaintingPanel;
import frontend.Utilities;
import shapes.Square;
import backend.Validations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class AddSquare extends JFrame {
    private JPanel contentPane;
    private JTextField xField;
    private JTextField yField;
    private JTextField sideField;
    private JButton backButton;
    private JButton addButton;

    public AddSquare(PaintingPanel paintingPanel, MainWindow mainWindow) {
        setContentPane(contentPane);
        setTitle("Add Square");
        setSize(320, 240);
        setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!Validations.isNumberValid(xField.getText()) || !Validations.isNumberValid(yField.getText())) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid position.");
                    return;
                }

                if (!Validations.isNumberValid(sideField.getText())) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid side length.");
                    return;
                }

                double x = Double.parseDouble(xField.getText());
                double y = Double.parseDouble(yField.getText());
                double side = Double.parseDouble(sideField.getText());

                Utilities.warnIfOutOfBorder(x, y);

                Square square = new Square();
                square.setProperties(Map.of("side", side, "X", x, "Y", y));
                paintingPanel.addShape(square);

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
