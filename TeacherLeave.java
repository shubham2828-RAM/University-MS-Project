package University_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import com.mysql.cj.protocol.Resultset;

import com.toedter.calendar.JDateChooser;
import net.proteanit.sql.DbUtils;


public class TeacherLeave  extends JFrame implements ActionListener{
    Choice crollno,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    TeacherLeave() {
        setLayout(null);
        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(80, 20, 300, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);

        JLabel lblrollno = new JLabel("Search ID: ");
        lblrollno.setBounds(80, 100, 200, 30);
        lblrollno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(lblrollno);

        crollno = new Choice();
        crollno.setBounds(80, 130, 200, 20);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lbldate = new JLabel("Date ");
        lbldate.setBounds(80, 165, 100, 20);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lbldate);
        dcdate = new JDateChooser();
        dcdate.setBounds(80, 195, 200, 20);
        add(dcdate);

        JLabel lbltime = new JLabel("Time ");
        lbltime.setBounds(80, 225, 100, 20);
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lbltime);
        ctime = new Choice();
        ctime.setBounds(80, 245, 200, 20);
        ctime.add("Full day");
        ctime.add("Half day");
        add(ctime);

        submit = new JButton("SUBMIT");
        submit.setBounds(80, 400, 120, 20);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBounds(230, 400, 120, 20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(cancel);


        setSize(500, 550);
        setLocation(450, 100);
        setVisible(true);
    }


        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == submit){
                String Id = crollno.getSelectedItem();
                String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
                String duration = ctime.getSelectedItem();

                try {
                    String query = "insert into teacherleave values('"+Id+"','"+date+"','"+duration+"')";
                    Conn co = new Conn();
                    co.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Leave Confirmed");
                    setVisible(false);
                }
                catch (Exception e ){
                    e.printStackTrace();

                }

            }
            else {
                setVisible(false);
            }



    }
    public static void main(String[] args) {
        new TeacherLeave();
    }
}
