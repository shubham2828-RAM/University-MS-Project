package University_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;

public class loginPage  {



        // Database credentials
        static final String DB_URL = "jdbc:mysql://localhost:3306/userdb";
        static final String USER = "root"; // MySQL username
        static final String PASS = "W7301@jqir#"; // MySQL password

        public static void main(String[] args) {
            
            JFrame frame = new JFrame("Login Page");
            frame.setSize(400, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Creating the panel at bottom and adding components
            JPanel panel = new JPanel();
            frame.add(panel);
            placeComponents(panel);


            frame.setSize(600,255);
            frame.setLocation(500,250);
            frame.setVisible(true);
        }

        private static void placeComponents(JPanel panel) {
            panel.setLayout(null);

            // User Label
            JLabel userLabel = new JLabel("User");
            userLabel.setBounds(10, 20, 80, 25);
            panel.add(userLabel);

            // User Text Field
            JTextField userText = new JTextField(20);
            userText.setBounds(100, 20, 165, 25);
            panel.add(userText);

            // Password Label
            JLabel passwordLabel = new JLabel("Password");
            passwordLabel.setBounds(10, 50, 80, 25);
            panel.add(passwordLabel);

            // Password Text Field
            JPasswordField passwordText = new JPasswordField(20);
            passwordText.setBounds(100, 50, 165, 25);
            panel.add(passwordText);

            // Login Button
            JButton loginButton = new JButton("login");
            loginButton.setBounds(10, 80, 80, 25);
            panel.add(loginButton);

            loginButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    String user = userText.getText();
                    String password = new String(passwordText.getPassword());
                    if (validateLogin(user, password))
                    {
                        JOptionPane.showMessageDialog(panel, "Login Successful!");
                    } else
                    {
                        JOptionPane.showMessageDialog(panel, "Invalid username or password.");
                    }
                }
            });

        }

        private static boolean validateLogin(String username, String password) {
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            try {
                // Register JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Open a connection
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root","W7301@jqir#");

                // Execute SQL query
                String sql = "SELECT * FROM users WHERE username = %s AND password = %s;";
//                pstmt = conn.prepareStatement(sql);
//                pstmt.setString(1, username);
//                pstmt.setString(2, password);
//                rs = pstmt.executeQuery();

                Statement  s = conn.createStatement();
                rs = s.executeQuery( String.format(sql, username, password) );
                System.out.println(rs.next());

                // Extract data from result set
                if (rs.next()) {
                    return true;
                }
            } catch (SQLException | ClassNotFoundException se) {
                se.printStackTrace();
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (pstmt != null) pstmt.close();
                    if (conn != null) conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            return false;
        }
    }


