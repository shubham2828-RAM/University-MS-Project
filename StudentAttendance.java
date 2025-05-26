package University_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentAttendance extends JFrame implements ActionListener {
    Choice studentID, attendanceStatus;
    JButton submit;

    StudentAttendance() {
        setLayout(null);

        JLabel heading = new JLabel("Mark Student Attendance");
        heading.setBounds(50, 20, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel lblID = new JLabel("Student ID:");
        lblID.setBounds(50, 80, 100, 20);
        add(lblID);

        studentID = new Choice();
        studentID.setBounds(160, 80, 150, 20);
        // You should fetch from DB here
        studentID.add("101");
        studentID.add("102");
        studentID.add("103");
        studentID.add("104");
        studentID.add("105");
        add(studentID);

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
        String id = studentID.getSelectedItem();
        String status = attendanceStatus.getSelectedItem();

        // Insert into MySQL database
        try {
            Conn c = new Conn();
            String query = "INSERT INTO student_attendance (student_id, status, date) VALUES ('" + id + "', '" + status + "', CURDATE())";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Attendance Marked");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentAttendance();
    }

}
