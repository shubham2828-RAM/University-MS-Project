package University_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class StudentReport extends JFrame implements ActionListener {
    JTextField rollInput;
    JButton search;
    JTextArea reportArea;

    // Hardcoded subject data
    Map<String, Map<String, Integer>> subjectData = new HashMap<>();

    StudentReport() {
        setTitle("Student Report Viewer");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblrollno = new JLabel("Enter Roll Number:");
        lblrollno.setBounds(50, 50, 200, 30);
        lblrollno.setFont(new Font("Times New Roman", Font.BOLD, 18));
        add(lblrollno);

        rollInput = new JTextField();
        rollInput.setBounds(220, 50, 200, 30);
        add(rollInput);

        search = new JButton("Search");
        search.setBounds(180, 100, 100, 30);
        search.addActionListener(this);
        add(search);

        reportArea = new JTextArea();
        reportArea.setBounds(50, 150, 400, 280);
        reportArea.setEditable(false);
        reportArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(reportArea);

        Map<String, Integer> student1 = new HashMap<>();
        student1.put("DAA", 85);
        student1.put("ME", 78);
        student1.put("JAVA", 90);
        student1.put("Chemistry", 70);
        student1.put("DM", 88);
        student1.put("ES", 76);
        subjectData.put("121049124", student1);

        Map<String, Integer> student2 = new HashMap<>();
        student2.put("DAA", 92);
        student2.put("ME", 88);
        student2.put("JAVA", 94);
        student2.put("Chemistry", 81);
        student2.put("DM", 79);
        student2.put("ES", 87);
        subjectData.put("121041824", student2);

        Map<String, Integer> student3 = new HashMap<>();
        student3.put("DAA", 92);
        student3.put("ME", 88);
        student3.put("JAVA", 94);
        student3.put("Chemistry", 81);
        student3.put("DM", 79);
        student3.put("ES", 87);
        subjectData.put("121043186", student3);

        Map<String, Integer> student4 = new HashMap<>();
        student4.put("DAA", 92);
        student4.put("ME", 88);
        student4.put("JAVA", 94);
        student4.put("Chemistry", 81);
        student4.put("DM", 79);
        student4.put("ES", 87);
        subjectData.put("121042711", student4);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String rollNo = rollInput.getText().trim();
        reportArea.setText("");

        try {
            Conn c = new Conn();

            // Fetch student info
            String studentQuery = "SELECT * FROM student WHERE rollno = '" + rollNo + "'";
            ResultSet rs = c.s.executeQuery(studentQuery);

            if (rs.next()) {
                reportArea.append("Name: " + rs.getString("name") + "\n");
                reportArea.append("Roll No: " + rs.getString("rollno") + "\n");
                reportArea.append("Email: " + rs.getString("email") + "\n");
                reportArea.append("Course: " + rs.getString("course") + "\n");
                reportArea.append("Branch: " + rs.getString("branch") + "\n");
            } else {
                reportArea.append("❌ No record found for Roll Number: " + rollNo);
                return;
            }

            reportArea.append("\nSubject-wise Marks:\n");

            Map<String, Integer> selectedSubjects = subjectData.get(rollNo);

            if (selectedSubjects != null) {
                for (Map.Entry<String, Integer> entry : selectedSubjects.entrySet()) {
                    reportArea.append(entry.getKey() + " : " + entry.getValue() + " Marks\n");
                }
            } else {
                reportArea.append("No subject marks found.\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
            reportArea.append("⚠️ Error fetching data.");
        }
    }

    public static void main(String[] args) {
        new StudentReport();
    }
}
