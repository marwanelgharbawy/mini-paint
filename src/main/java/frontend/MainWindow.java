package frontend;

import frontend.add.*;
import frontend.resize.*;

import shapes.AbstractShape;
import shapes.Circle;
import shapes.LineSegment;
import shapes.Rectangle;
import shapes.Square;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JPanel contentPane;
    private PaintingPanel canvas;
    private JButton circleButton;
    private JButton lineSegmentButton;
    private JButton squareButton;
    private JButton rectangleButton;
    private JComboBox shapeDropDown;
    private JButton colorizeButton;
    private JButton deleteButton;
    private JButton moveButton;
    private JButton resizeButton;

    public MainWindow() {
        // Deleted the .form file because I want to add a modified JPanel called PaintingPanel

        // Initialization
        setTitle("Vector Drawing Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize panels
        initializeTopPanel();
        initializeLeftPanel();
        initializeCanvas();
        setComponentSizes();

        setSize(1000,600);
        setVisible(true);

        addEventListeners();
    }

    private void initializeTopPanel() {
        JPanel topPanel = new JPanel(new GridLayout(1, 5, 10, 10));

        topPanel.add(new JLabel("")); // Leaving first column empty

        topPanel.add(circleButton = new JButton("Circle"));
        topPanel.add(lineSegmentButton = new JButton("LineSegment"));
        topPanel.add(squareButton = new JButton("Square"));
        topPanel.add(rectangleButton = new JButton("Rectangle"));

        add(topPanel, BorderLayout.NORTH);
    }

    private void initializeLeftPanel() {
        JPanel leftPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding values
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        leftPanel.add(new JLabel("Select Shape"), gbc);
        gbc.gridy++;
        
        // Empty combo box, will add its components later
        shapeDropDown = new JComboBox<>();
        shapeDropDown.setPreferredSize(new Dimension(100, 25));
        leftPanel.add(shapeDropDown, gbc);
        gbc.gridy++;

        // Colorize and Delete buttons
        JPanel buttonPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        buttonPanel1.add(colorizeButton = new JButton("Colorize"));
        buttonPanel1.add(deleteButton = new JButton("Delete"));

        leftPanel.add(buttonPanel1, gbc);
        gbc.gridy++;


        // Move and Resize buttons
        JPanel buttonPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        buttonPanel2.add(moveButton = new JButton("Move"));
        buttonPanel2.add(resizeButton = new JButton("Resize"));

        leftPanel.add(buttonPanel2, gbc);
        gbc.gridy++;

        add(leftPanel, BorderLayout.WEST);
    }

    private void setComponentSizes() {
        moveButton.setPreferredSize(new Dimension(100, 25));
        resizeButton.setPreferredSize(new Dimension(100, 25));
        colorizeButton.setPreferredSize(new Dimension(100, 25));
        deleteButton.setPreferredSize(new Dimension(100, 25));
//        canvas.setMaximumSize(new Dimension(800, 600));
    }

    private void initializeCanvas() {
        canvas = new PaintingPanel();
        canvas.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        add(canvas, BorderLayout.CENTER);
    }

    public void updateShapeDropDown() {
        shapeDropDown.removeAllItems();
        for (AbstractShape shape : canvas.getGraphicsEngine().getShapes()) {
            shapeDropDown.addItem(shape); // Override toString() method
        }
    }

    private void addEventListeners() {
        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Rectangle button clicked");
                new AddRectangle(canvas, MainWindow.this);
            }
        });

        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Square button clicked");
                new AddSquare(canvas, MainWindow.this);
            }
        });

        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Circle button clicked");
                new AddCircle(canvas, MainWindow.this);
            }
        });

        lineSegmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Line Segment button clicked");
                new AddLineSegment(canvas, MainWindow.this);
            }
        });

        colorizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Colorize button clicked");

                if (shapeDropDown.getItemCount() == 0) { // No shapes to colorize
                    JOptionPane.showMessageDialog(null, "No shapes to colorize", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Color color = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);

                AbstractShape selectedShape = (AbstractShape) shapeDropDown.getSelectedItem();
                if (selectedShape != null) {
                    selectedShape.setFillColor(color);
                    canvas.repaint();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete button clicked");

                if (shapeDropDown.getItemCount() == 0) { // No shapes to delete
                    JOptionPane.showMessageDialog(null, "No shapes to delete", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                AbstractShape selectedShape = (AbstractShape) shapeDropDown.getSelectedItem();
                if (selectedShape != null) {
                    canvas.getGraphicsEngine().removeShape(selectedShape);
                    updateShapeDropDown();
                    canvas.repaint();
                }
            }
        });

        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Move button clicked");

                if (shapeDropDown.getItemCount() == 0) { // No shapes to move
                    JOptionPane.showMessageDialog(null, "No shapes to move", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                AbstractShape selectedShape = (AbstractShape) shapeDropDown.getSelectedItem();
                if (selectedShape instanceof LineSegment) {
                    new ModifyLine((LineSegment) selectedShape, canvas);
                    return;
                }

                if (selectedShape != null) {
                    new MoveShape(selectedShape, canvas);
                }
            }
        });

        resizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Resize button clicked");

                if (shapeDropDown.getItemCount() == 0) { // No shapes to resize
                    JOptionPane.showMessageDialog(null, "No shapes to resize", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                AbstractShape selectedShape = (AbstractShape) shapeDropDown.getSelectedItem();
                if (selectedShape != null) {
                    // Depending on the shape, a different dialog will be shown
                    switch (selectedShape) {
                        case Square square -> new ResizeSquare((Square) selectedShape, canvas);
                        case Rectangle rectangle -> new ResizeRectangle((Rectangle) selectedShape, canvas);
                        case Circle circle -> new ResizeCircle((Circle) selectedShape, canvas);
                        case LineSegment lineSegment -> new ModifyLine((LineSegment) selectedShape, canvas);
                        default -> { // Unknown shape
                            System.out.println("Error, shape type not recognized");
                            JOptionPane.showMessageDialog(null, "An error has occurred", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
    }
}