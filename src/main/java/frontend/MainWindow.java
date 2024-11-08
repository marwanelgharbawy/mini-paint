package frontend;

import shapes.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

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
        // JPanel leftPanel = new JPanel(new GridLayout(4, 2, 30, 5));
        JPanel leftPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding values
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;


        leftPanel.add(new JLabel("Select Shape"), gbc);
        
        // Empty combo box, will add its components later
        shapeDropDown = new JComboBox<>();
        shapeDropDown.setPreferredSize(new Dimension(150, 25));
        gbc.gridy++;
        leftPanel.add(shapeDropDown, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        buttonPanel.add(colorizeButton = new JButton("Colorize"));
        buttonPanel.add(deleteButton = new JButton("Delete"));
        gbc.gridy++;
        leftPanel.add(buttonPanel, gbc);

        add(leftPanel, BorderLayout.WEST);
    }

    private void initializeCanvas() {
        canvas = new PaintingPanel();
        canvas.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        add(canvas, BorderLayout.CENTER);
    }

    private void addEventListeners() {
        rectangleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Rectangle button clicked");
                new AddRectangle(canvas);
            }
        });

        squareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Square button clicked");
                new AddSquare(canvas);
            }
        });

        circleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Circle button clicked");
            }
        });

        lineSegmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Line Segment button clicked");
            }
        });

        colorizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Colorize button clicked");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete button clicked");
            }
        });
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
    }
}