package University_Management_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;

    Conn(){
        try{
              Class.forName("com.mysql.cj.jdbc.Driver");
              c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","W7301@jqir#") ;
              s = c.createStatement();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
