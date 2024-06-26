package University_Management_System;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

public class login extends JFrame implements ActionListener {
    JButton login , cancel;
    JTextField tfuser, tfpass;
    login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
//      USERNAME layout
        JLabel lblusername = new JLabel("USERNAME");
        lblusername.setBounds(40,20,100,20);
        add(lblusername);
        tfuser = new JTextField();
        tfuser.setBounds(150,20,150,20);
        add(tfuser);

//       PASSWORD layout
        JLabel lblpassword = new JLabel("PASSWORD");
        lblpassword.setBounds(40,60,100,20);
        add(lblpassword);
        tfpass = new JPasswordField();
        tfpass.setBounds(150,60,150,20);
        add(tfpass);

//        login Button layout
        login = new JButton("LOGIN");
        login.setBounds(40,112,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma",Font.BOLD,18));
        add(login);

//        Cancel layout
        cancel = new JButton("CANCEL");
        cancel.setBounds(180,112,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,18));
        add(cancel);

//        user image layout
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/second.jpg"));
        Image i2  = i1.getImage().getScaledInstance(200 ,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        image.setBounds(350,0,200,200);
        add(image);






        setSize(600,255);
        setLocation(500,250);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            String username = tfuser.getText();
            String password = tfpass.getText();

            try{
                String query = String.format("select * from login where username = '%s' and password = '%s' ", username, password);
//                System.out.println(query);
                Conn c = new Conn();
                ResultSet rs =  c.s.executeQuery(query);

               if (rs.next()){
                    setVisible(false);
                    new project();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid username and password");
                    setVisible(false);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new login();


    }
}
