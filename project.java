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
        JMenu exit = new JMenu("EXIT->");
        exit.setForeground(Color.BLUE);
        exit.addActionListener(this);
        mb.add(exit);

        setJMenuBar(mb);

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


    }
    public static void main(String[] args) {
        new project();


    }
}
