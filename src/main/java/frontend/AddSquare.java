package frontend;

import shapes.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class AddSquare extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton backButton;
    private JButton addButton;

    public AddSquare(PaintingPanel paintingPanel) {
        setContentPane(panel1);
        setTitle("Add Square");
        setSize(320, 240);
        setVisible(true);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x = Double.parseDouble(textField1.getText());
                double y = Double.parseDouble(textField2.getText());
                double side = Double.parseDouble(textField3.getText());
                Square square = new Square();
                square.setPosition(new Point((int) x, (int) y));
                square.setProperties(Map.of("side", side));
                paintingPanel.addShape(square);
                dispose();
            }
        });
    }
}
