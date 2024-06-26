package University_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import com.mysql.cj.protocol.Resultset;
import com.toedter.calendar.JDateChooser;

public class Addteacher extends JFrame implements ActionListener {
    JTextField tfname, tffname,tfmname,tfaddress,tfphone,tfemail,tfx,tfxii;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox cbcourse;
    JComboBox cbbranch;
    JButton submit, cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L)+ 1000L );
    Addteacher(){
        setSize(900,780);
        setLocation(350,35);
        getContentPane().setBackground(Color.LIGHT_GRAY);

        setLayout(null);

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(250,30,500,50);
        heading.setFont(new Font("Times New Roman",Font.BOLD,45));
        add(heading);

//        teacher name
        JLabel lblname = new JLabel("Teacher Name:-");
        lblname.setBounds(50,100,200,30);
        lblname.setFont(new Font("Times New Roman",Font.BOLD,28));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(300,100,250,30);
        add(tfname);

//        teacher's father's name
        JLabel lblfname = new JLabel("Father Name:-");
        lblfname.setBounds(50,150,200,30);
        lblfname.setFont(new Font("Times New Roman",Font.BOLD,28));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(300,150,250,30);
        add(tffname);

//        teacher's mother's name
        JLabel lblmname = new JLabel("Mother Name:-");
        lblmname.setBounds(50,200,200,30);
        lblmname.setFont(new Font("Times New Roman",Font.BOLD,28));
        add(lblmname);

        tfmname = new JTextField();
        tfmname.setBounds(300,200,250,30);
        add(tfmname);

//        teacher id
        JLabel lblrollno = new JLabel("Teacher Id:-  ");
        lblrollno.setBounds(50,250,200,30);
        lblrollno.setFont(new Font("Times New Roman",Font.BOLD,28));
        add(lblrollno);

        labelrollno = new JLabel("12"+first4);
        labelrollno.setBounds(300,250,250,30);
        labelrollno.setFont(new Font("Times New Roman",Font.BOLD,28));
        add(labelrollno);

//        dob
        JLabel lbldob = new JLabel("Birth Date:-  ");
        lbldob.setBounds(50,300,200,30);
        lbldob.setFont(new Font("Times New Roman",Font.BOLD,28));
        add(lbldob);
        dcdob = new JDateChooser();
        dcdob.setBounds(300,300,200,30);
        add(dcdob);

//        address
        JLabel lbladdress = new JLabel("Address:-");
        lbladdress.setBounds(50,350,200,30);
        lbladdress.setFont(new Font("Times New Roman",Font.BOLD,28));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(300,350,450,30);
        add(tfaddress);

//        phone number
        JLabel lblphone = new JLabel("Phone No.(+91):-");
        lblphone.setBounds(50,400,200,30);
        lblphone.setFont(new Font("Times New Roman",Font.BOLD,28));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(300,400,250,30);
        add(tfphone);

//        email
        JLabel lblemail = new JLabel("Enter Email:-");
        lblemail.setBounds(50,450,200,30);
        lblemail.setFont(new Font("Times New Roman",Font.BOLD,28));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(300,450,250,30);
        add(tfemail);

//        bachalor degree
        JLabel lblX = new JLabel("Bachalor Degree:-");
        lblX.setBounds(50,500,250,30);
        lblX.setFont(new Font("Times New Roman",Font.BOLD,28));
        add(lblX);

        tfx = new JTextField();
        tfx.setBounds(300,500,150,30);
        add(tfx);

//        master degree
        JLabel lblXII = new JLabel("Master degree:-");
        lblXII.setBounds(50,550,200,30);
        lblXII.setFont(new Font("Times New Roman",Font.BOLD,28));
        add(lblXII);

        tfxii = new JTextField();
        tfxii.setBounds(300,550,150,30);
        add(tfxii);

//        bachalor subjects you can teach
        JLabel lblcou = new JLabel("Bach.You Teach:- ");
        lblcou.setBounds(50,600,300,30);
        lblcou.setFont(new Font("Times New Roman",Font.BOLD,28));
        add(lblcou);

        String course[] = {"Select","B.Tech","BBA","B.Comm","BA","BCA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(300,600,100,30);
        add(cbcourse);
//
        JLabel lblbranch = new JLabel("Mast. you teach:- ");
        lblbranch.setBounds(50,650,300,30);
        lblbranch.setFont(new Font("Times New Roman",Font.BOLD,28));
        add(lblbranch);

        String branch[] = {"select","M.tech","MBA","M.Comm","MA","MCA"};
        cbbranch = new JComboBox<>(branch);
        cbbranch.setBounds(300,650,230,30);
        add(cbbranch);

//        submit
        submit = new JButton("SUBMIT");
        submit.setBounds(335,700,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,18));
        add(submit);

//       cancel button
        cancel = new JButton("CANCEL");
        cancel.setBounds(470,700,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,18));
        add(cancel);

        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String name = tfname.getText();
            String fname = tffname.getText();
            String mname = tfmname.getText();
            String rollno = labelrollno.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String course = (String) cbcourse.getSelectedItem();
            String branch  = (String) cbbranch.getSelectedItem();

            try{
                String query = "insert into teacher values('"+name+"','"+fname+"','"+mname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+course+"','"+branch+"')";

                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Teacher Detail Inserted Successfull");
                setVisible(false);



            }
            catch (Exception e){
                e.printStackTrace();
            }


        }
        else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Addteacher();
       
    }
}
