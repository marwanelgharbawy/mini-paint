package frontend.add;

import frontend.MainWindow;
import frontend.PaintingPanel;
import frontend.Utilities;
import shapes.LineSegment;
import backend.Validations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class AddLineSegment extends JFrame{
    private JPanel panel1;
    private JTextField startX;
    private JTextField startY;
    private JTextField endX;
    private JTextField endY;
    private JButton backButton;
    private JButton addButton;

    public AddLineSegment(PaintingPanel paintingPanel, MainWindow mainWindow) {
        setContentPane(panel1);
        setTitle("Add Line Segment");
        setSize(320, 240);
        setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!Validations.isNumberValid(startX.getText()) || !Validations.isNumberValid(startY.getText())) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid start position.");
                    return;
                }

                if (!Validations.isNumberValid(endX.getText()) || !Validations.isNumberValid(endY.getText())) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid end position.");
                    return;
                }

                double x1 = Double.parseDouble(startX.getText());
                double y1 = Double.parseDouble(startY.getText());
                double x2 = Double.parseDouble(endX.getText());
                double y2 = Double.parseDouble(endY.getText());
                Utilities.warnIfOutOfBorder(x1, y1, x2, y2);

                LineSegment lineSegment = new LineSegment();
                lineSegment.setPosition(new Point((int) x1, (int) y1));
                lineSegment.setProperties(Map.of("startX", x1, "startY", y1, "endX", x2, "endY", y2));
                paintingPanel.addShape(lineSegment);

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
