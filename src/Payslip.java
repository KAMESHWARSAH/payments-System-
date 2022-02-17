
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class Payslip extends JFrame implements ActionListener{
    Choice c1;
    JTextArea t1;
    JButton b1;
    Payslip(){
       setSize(800,700);
       setLocation(400,150);
       c1=new Choice();
       try{
            javaconnect  c = new javaconnect();
            ResultSet rs = c.stm.executeQuery("select * from salary");
            
            while(rs.next()){
                //c2.addItem(rs.getString("id"));
                c1.add(rs.getString("id"));
               // System.out.println("id is"+c2);
            }
            
        }catch(Exception e){
            
        }
       
       
       setLayout(new BorderLayout());
       JPanel p1 = new JPanel();
       p1.add(new JLabel("select Id"));
       p1.add(c1);
       add(p1,"North");
       t1=new JTextArea(30,80);
       JScrollPane jsp = new JScrollPane(t1);
       Font f1= new Font("Arieal",Font.BOLD,20);
       t1.setFont(f1);
       b1=new JButton("Generate pay slip");
       //add(b1,"SOUTH");
       //add(jsp,"center");
       b1.addActionListener(this);
       
      // b1=new JButton("update");
      
      
    // b1.setBounds(40,400,150,30);
     add(b1,BorderLayout.SOUTH);
     add(jsp,BorderLayout.CENTER);
     b1.setBackground(Color.white);
     b1.setForeground(Color.black);
    // b1.addActionListener(this);
      
       
       
       
    }
    public void actionPerformed(ActionEvent ae){
       try{
          
           try {
               javaconnect c = new javaconnect();
               ResultSet rs=c.stm.executeQuery("select * from employee where id ="+c1.getSelectedItem());
               System.out.println("kk1"+c1);
               rs.next();
               String name= rs.getString("name");
               rs.close();
               
               rs=c.stm.executeQuery("select * from salary where id="+c1.getSelectedItem());
               
               java.util.Date d1 =new java.util.Date();
               int month = d1.getMonth();
               t1.setText("--------------- PAY SLIP FOR THE MONTH OF "+month+" , 2020 ------------");
               t1.append("\n");
               
               if(rs.next()){
                   t1.append("\n       Employee Id "+rs.getString("id"));
                   t1.append("\n       Employee Nmae "+name);
                   
                   t1.append("\n-------------------------------------------------------------------");
                   t1.append("\n");
                   
                   double hra = rs.getDouble("hra");
                   t1.append("\n             HRA           : "+hra);
                   double da = rs.getDouble("da");
                   t1.append("\n             DA            : "+da);
                   double med = rs.getDouble("med");
                   t1.append("\n             MED           : "+med);
                   double pf = rs.getDouble("pf");
                   t1.append("\n             PF            : "+pf);
                   
                   double basic = rs.getDouble("basic_salary");
                   double gross = hra+da+med+pf+basic;
                   
                   double net = gross-pf;
                   t1.append("\n             BASIC SALARY : "+basic);
                   
                   t1.append("\n -----------------------------------------------------------------");
                   t1.append("\n");
                   t1.append("\n GROSS SALARY : "+gross+"\n NET SALATY : "+net);
                   t1.append("\n  Tex   : 2.14 of gross "+ (gross*2.1/100));
                   t1.append("\n");
                   t1.append("\n");
                   t1.append("\n");
                   t1.append("  (Signature)  ");
                   
       } 
               
               
           } catch (SQLException ex) {
               Logger.getLogger(Payslip.class.getName()).log(Level.SEVERE, null, ex);
           }
            
           
       }catch(Exception e){
           
               }
    }
    public static void main(String s[]){
        new Payslip().setVisible(true);
    }
}
