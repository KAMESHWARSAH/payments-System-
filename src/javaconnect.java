/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
import java.sql.*;
import javax.swing.JOptionPane;


public class javaconnect {
 Connection conn;
 Statement stm;

 
    public javaconnect(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/paymentsystem","root","rootwdp");
        stm = conn.createStatement();
            /*
            */
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
}
