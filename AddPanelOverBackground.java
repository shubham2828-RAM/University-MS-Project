package University_Management_System;


import javax.swing.*;
import java.awt.*;

public class AddPanelOverBackground extends JPanel {

    private Image backgroundImage;

    public AddPanelOverBackground() {
        // Load the background image
        backgroundImage = new ImageIcon("path_to_your_image.jpg").getImage();
        setLayout(null); // Use null layout for absolute positioning

        // Create a new panel to add over the background
        JPanel overlayPanel = new JPanel();
        overlayPanel.setBounds(50, 50, 300, 200); // Set position and size
        overlayPanel.setBackground(new Color(255, 255, 255, 180)); // Semi-transparent background

        // Add a label to the overlay panel
        overlayPanel.add(new JLabel("This is the new section"));

        // Add the overlay panel to the main panel (which has the background image)
        add(overlayPanel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        AddPanelOverBackground panel = new AddPanelOverBackground();

        frame.add(panel); // Adding the main panel with background image and overlay panel
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

