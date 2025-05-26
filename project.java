package University_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

public class project extends JFrame implements ActionListener{
    project(){

        setSize(1540,850);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/first.jpg"));
        Image i2  = i1.getImage().getScaledInstance(1500 ,750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        // Enquiry Panel - 8cm x 8cm
        JPanel enquiryPanel = new JPanel();
        enquiryPanel.setLayout(null);
        enquiryPanel.setBackground(new Color(224, 255, 255)); // Lighter cyan for a fresh look
        enquiryPanel.setBounds(20, 150, 302, 290); // 8cm x 8cm
        enquiryPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true));
        image.add(enquiryPanel);

        // Panel Heading - centered and styled
        JLabel enquiryHeading = new JLabel("Enquiry");
        enquiryHeading.setFont(new Font("Tahoma", Font.BOLD, 18));
        enquiryHeading.setHorizontalAlignment(SwingConstants.CENTER);
        enquiryHeading.setBounds(0, 10, 302, 25);
        enquiryPanel.add(enquiryHeading);

// Separator line under heading
        JSeparator separator = new JSeparator();
        separator.setBounds(20, 40, 260, 1);
        separator.setForeground(Color.GRAY);
        enquiryPanel.add(separator);

// Name Label & Field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 55, 60, 20);
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        enquiryPanel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(90, 55, 190, 22);
        enquiryPanel.add(nameField);

// Mobile Label & Field
        JLabel mobLabel = new JLabel("Mobile:");
        mobLabel.setBounds(20, 90, 60, 20);
        mobLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        enquiryPanel.add(mobLabel);

        JTextField mobField = new JTextField();
        mobField.setBounds(90, 90, 190, 22);
        enquiryPanel.add(mobField);

// Email Label & Field
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 125, 60, 20);
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        enquiryPanel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(90, 125, 190, 22);
        enquiryPanel.add(emailField);

// Subject Label & Field
        JLabel subjectLabel = new JLabel("Subject:");
        subjectLabel.setBounds(20, 160, 60, 20);
        subjectLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        enquiryPanel.add(subjectLabel);

        JTextField subjectField = new JTextField();
        subjectField.setBounds(20, 185, 260, 25);
        enquiryPanel.add(subjectField);

// Submit Button - centered
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(101, 230, 100, 30);
        submitButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        submitButton.setBackground(new Color(100, 149, 237)); // Cornflower blue
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        enquiryPanel.add(submitButton);

// Button Action
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String mobile = mobField.getText();
            String email = emailField.getText();
            String subject = subjectField.getText();

            try {
                Conn c = new Conn();
                String query = "INSERT INTO enquiry (name, mobile, email, subject) VALUES ('" +
                        name + "', '" + mobile + "', '" + email + "', '" + subject + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Enquiry Submitted!\nThank you, " + name);

                // Optional: clear fields after submission
                nameField.setText("");
                mobField.setText("");
                emailField.setText("");
                subjectField.setText("");

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error submitting enquiry.");
            }
        });







        // Marquee Banner Panel
        JPanel bannerPanel = new JPanel();
        bannerPanel.setLayout(null);
        bannerPanel.setBackground(Color.cyan);
        bannerPanel.setBounds(0, 10, 1540, 56); // 2cm from top, 2cm tall
        image.add(bannerPanel); // Add to background image

        JLabel bannerText = new JLabel("Welcome to Bright Career Institute | Admissions Open | Contact: brightcareerinst@gmail.com");
        bannerText.setFont(new Font("Tahoma", Font.BOLD, 24));
        bannerText.setForeground(Color.RED);
        bannerText.setBounds(1540, 10, 1500, 30); // Start from right, scroll left
        bannerPanel.add(bannerText);

        // Scroll animation
        Timer timer = new Timer(10, new ActionListener() {
            int x = 1540;
            public void actionPerformed(ActionEvent e) {
                x -= 2;
                if (x < -bannerText.getWidth()) {
                    x = bannerPanel.getWidth();
                }
                bannerText.setLocation(x, 10);
            }
        });
        timer.start();



        JMenuBar mb = new JMenuBar();

//        NEW information
        JMenu newinfor = new JMenu("New Information");
        newinfor.setForeground(Color.BLUE);
        mb.add(newinfor);

        JMenuItem facultyinfo = new JMenuItem("New faculty Information");
        facultyinfo.setBackground(Color.white);
        facultyinfo.addActionListener(this);
        newinfor.add(facultyinfo);

        JMenuItem Studentinfo = new JMenuItem("New Student Information");
        Studentinfo.setBackground(Color.white);
        Studentinfo.addActionListener(this);
        newinfor.add(Studentinfo);

//        Details information
        JMenu details = new JMenu("View  Details");
        details.setForeground(Color.red);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.white);
        details.add(facultydetails);

        JMenuItem Studentdetails = new JMenuItem("View Student Details");
        Studentdetails.setBackground(Color.white);
        Studentdetails.addActionListener(this);
        details.add(Studentdetails);

//      Leave
        JMenu Leaves = new JMenu("Leaves");
        Leaves.setForeground(Color.blue);
        mb.add(Leaves);

        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.white);
        facultyLeave.addActionListener(this);
        Leaves.add(facultyLeave);

        JMenuItem StudentLeave = new JMenuItem("Student Leave");
        StudentLeave.setBackground(Color.white);
        StudentLeave.addActionListener(this);
        Leaves.add(StudentLeave);

//        Attendence for student
        JMenu attendance = new JMenu("Attendance");
        attendance.setForeground(Color.BLUE);
        mb.add(attendance);

        JMenuItem studentAttendance = new JMenuItem("Student Attendance");
        studentAttendance.setBackground(Color.white);
        studentAttendance.addActionListener(this);
        attendance.add(studentAttendance);

        JMenuItem facultyAttendance = new JMenuItem("Faculty Attendance");
        facultyAttendance.setBackground(Color.white);
        facultyAttendance.addActionListener(this);
        attendance.add(facultyAttendance);

        // Report
        JMenu reportMenu = new JMenu("Report");
        reportMenu.setForeground(Color.MAGENTA);
        mb.add(reportMenu);

        JMenuItem studentReport = new JMenuItem("Student Report");
        studentReport.setBackground(Color.white);
        studentReport.addActionListener(this);
        reportMenu.add(studentReport);



//        utility
        JMenu Utility = new JMenu("Utility");
        Utility.setForeground(Color.RED);
        mb.add(Utility);

        JMenuItem Notepad = new JMenuItem("Notepad");
        Notepad.setBackground(Color.white);
        Notepad.addActionListener(this);
        Utility.add(Notepad);

        JMenuItem Cal = new JMenuItem("Calculator");
        Cal.setBackground(Color.white);
        Cal.addActionListener(this);
        Utility.add(Cal);

//        Exit
        JMenu exit = new JMenu("EXIT");
        exit.setForeground(Color.BLUE);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setBackground(Color.white);
        exitItem.addActionListener(this);
        exit.add(exitItem);
        mb.add(exit);

        setJMenuBar(mb);



        // Footer Panel
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(null);
        footerPanel.setBackground(new Color(245, 245, 245));  // Light gray background
        footerPanel.setBounds(0, 715, 1540, 70); // Position at bottom
        image.add(footerPanel);

// Footer Links
        String[] footerItems = {"SITE MAP", "PRIVACY POLICY", "TERM & CONDITIONS", "CONTACT US"};
        int totalWidth = footerItems.length * 150 + (footerItems.length - 1) * 20; // 150 width + 20 spacing
        int startX = (1540 - totalWidth) / 2; // Centering calculation

        int x = startX;
        for (int i = 0; i < footerItems.length; i++) {
            JLabel label = new JLabel(footerItems[i]);
            label.setFont(new Font("Tahoma", Font.BOLD, 12));
            label.setForeground(Color.DARK_GRAY);
            label.setBounds(x, 10, 150, 20);
            label.setCursor(new Cursor(Cursor.HAND_CURSOR));
            footerPanel.add(label);
            x += 180;

            if (i < footerItems.length - 1) {
                JLabel divider = new JLabel("|");
                divider.setFont(new Font("Tahoma", Font.BOLD, 12));
                divider.setBounds(x, 10, 10, 20);
                footerPanel.add(divider);
                x += 50;
            }
        }


// Copyright
        JLabel copyright = new JLabel("COPYRIGHT © 2025. UNIVERSITY. ALL RIGHTS RESERVED.");
        copyright.setFont(new Font("Tahoma", Font.PLAIN, 12));
        copyright.setForeground(Color.BLACK);
        copyright.setBounds(575, 35, 600, 20);
        footerPanel.add(copyright);




        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();

        if (msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }
            catch (Exception e){}
        }
        else if (msg.equals("Calculator")) {
            try {
                 Runtime.getRuntime().exec("calc.exe");
            }
            catch (Exception e) {}
        } else if (msg.equals("New Student Information")) {
            new AddStudent();

        }
        else if (msg.equals("View Student Details")) {
            new StudentDetails();
        }
        else if(msg.equals("Student Leave")){
            new StudentLeave();
        }
        else if (msg.equals("New faculty Information")) {
            new Addteacher();
        }
        else if(msg.equals("Faculty Leave")){
            new TeacherLeave();
        }
        else if (msg.equals("Student Attendance")) {
            new StudentAttendance();
        }
        else if (msg.equals("Faculty Attendance")) {
            new FacultyAttendance();
        }
        else if (msg.equals("Student Report")) {
            new StudentReport();  // this class we will define below
        }

        else if (msg.equals("Exit")) {
            int response = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to exit?",
                    "Confirm Exit",
                    JOptionPane.YES_NO_OPTION
            );
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }

        }




    }
    public static void main(String[] args) {
        new project();
    }
}
