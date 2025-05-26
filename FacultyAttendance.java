package University_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FacultyAttendance extends JFrame implements ActionListener {

    Choice FacultyID, attendanceStatus;
    JButton submit;

    FacultyAttendance() {
        setLayout(null);

        JLabel heading = new JLabel("Mark Faculty Attendance");
        heading.setBounds(50, 20, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblID = new JLabel("Faculty ID:");
        lblID.setBounds(50, 80, 100, 20);
        add(lblID);

        FacultyID = new Choice();
        FacultyID.setBounds(160, 80, 150, 20);
        // You should fetch from DB here
        FacultyID.add("201");
        FacultyID.add("202");
        add(FacultyID);

        JLabel lblStatus = new JLabel("Attendance:");
        lblStatus.setBounds(50, 120, 100, 20);
        add(lblStatus);

        attendanceStatus = new Choice();
        attendanceStatus.setBounds(160, 120, 150, 20);
        attendanceStatus.add("Present");
        attendanceStatus.add("Absent");
        add(attendanceStatus);

        submit = new JButton("Submit");
        submit.setBounds(100, 180, 100, 30);
        submit.addActionListener(this);
        add(submit);

        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String id = FacultyID.getSelectedItem();
        String status = attendanceStatus.getSelectedItem();

        // Insert into MySQL database
        try {
            Conn c = new Conn();
            String query = "INSERT INTO faculty_attendance  (faculty_id , status, date) VALUES ('" + id + "', '" + status + "', CURDATE())";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Attendance Marked");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FacultyAttendance();
    }
}
