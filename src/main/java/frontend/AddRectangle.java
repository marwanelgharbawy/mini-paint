package frontend;

import shapes.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class AddRectangle extends JFrame {
    private JPanel contentPane;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton backButton;
    private JButton addButton;

    public AddRectangle(PaintingPanel paintingPanel) {
        setContentPane(contentPane);
        setTitle("Add Rectangle");
        setSize(320, 240);
        setVisible(true);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x = Double.parseDouble(textField1.getText());
                double y = Double.parseDouble(textField2.getText());
                double width = Double.parseDouble(textField3.getText());
                double height = Double.parseDouble(textField4.getText());
                Rectangle rectangle = new Rectangle();
                rectangle.setPosition(new Point((int) x, (int) y));
                rectangle.setProperties(Map.of("width", width, "height", height));
                paintingPanel.addShape(rectangle);
                dispose();
            }
        });
    }
}
