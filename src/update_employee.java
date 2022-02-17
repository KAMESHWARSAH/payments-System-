
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class update_employee extends JFrame implements ActionListener, ItemListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,emp;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c1,c2;
    
    update_employee(){
        super("update employee");
        setLayout(null);
        getContentPane().setBackground(Color.white);
        c2=new Choice ();
        c2.setBounds(160,40,200,20);
        
        try{
            javaconnect  c = new javaconnect();
            ResultSet rs = c.stm.executeQuery("select * from employee");
            
            while(rs.next()){
                //c2.addItem(rs.getString("id"));
                c2.add(rs.getString("id"));
                System.out.println("id is"+c2);
            }
            
        }catch(Exception e){
            
        }
        
        emp=new JLabel("select empo");
        emp.setBounds(40,40,100,20);
        add(emp);
        add(c2);
        
      l1= new JLabel("Name : ");
      t1=new JTextField(15);
      l1.setBounds(40,80,100,20);
      t1.setBounds(160,80, 200,20);
      add(l1);
      add(t1);
      
      c1 =new Choice();
      c1.add("male");
      c1.add("female");
      
      l2= new JLabel("Gender");
      l2.setBounds(40,120,100,20);
      c1.setBounds(160,120, 200,20);
      add(l2);
      add(c1);
      
      l3= new JLabel("Address : ");
      t3=new JTextField(15);
      l3.setBounds(40,160,100,20);
      t3.setBounds(160,160, 200,20);
      add(l3);
      add(t3);
      
      l4= new JLabel("State : ");
      t4=new JTextField(15);
      l4.setBounds(40,200,100,20);
      t4.setBounds(160,200, 200,20);
      add(l4);
      add(t4);
      
      l5= new JLabel("City : ");
      t5=new JTextField(15);
      l5.setBounds(40,240,100,20);
      t5.setBounds(160,240, 200,20);
      add(l5);
      add(t5);
      
      l6= new JLabel("Email : ");
      t6=new JTextField(15);
      l6.setBounds(40,280,100,20);
      t6.setBounds(160,280, 200,20);
      add(l6);
      add(t6);
      
      l7= new JLabel("Phone  : ");
      t7=new JTextField(15);
      l7.setBounds(40,320,100,20);
      t7.setBounds(160,320, 200,20);
      add(l7);
      add(t7);
      
      b1=new JButton("update");
      b2=new JButton("Delete");
      
      b1.setBounds(40,400,150,30);
      b2.setBounds(200,400,150,30);
      add(b1);
      add(b2);
      b1.setBackground(Color.black);
      b1.setForeground(Color.white);
      b2.setBackground(Color.black);
      b2.setForeground(Color.white);
      
      b1.addActionListener(this);
      b2.addActionListener(this);
      c2.addItemListener(this);
      
      setVisible(true);
      setSize(400,550);
      setLocation(600,200);
      
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
           String n = t1.getText();
           String g = c1.getSelectedItem();
           String a = t3.getText();
           String s = t4.getText();
           String c = t5.getText();
           String e = t6.getText();
           String p = t7.getText();
           
           String qry="update employee set name='"+n+"', gender='"+g+"', address='"+a+"', state='"+s+"', city='"+c+"', email='"+e+"', phone='"+p+"' where id='"+c2+"'";
           try{
               javaconnect c11=new javaconnect();
               c11.stm.executeUpdate(qry);
               System.out.println("data .. "+qry);
               JOptionPane.showMessageDialog(null,"Employee Update");
               
           }catch(Exception ee){
               ee.printStackTrace();
           }
       }
       if(ae.getSource()==b2){
           javaconnect c1 = new javaconnect();
           try {
               c1.stm.executeUpdate("delete from employee where id="+c2.getSelectedItem());
               JOptionPane.showMessageDialog(null,"Employee Deleted");
               this.setVisible(false);
           } catch (SQLException ex) {
               Logger.getLogger(update_employee.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }
        
    }
    public void itemStateChanged(ItemEvent ie){
        try{
            javaconnect c1= new javaconnect();
            ResultSet rs=c1.stm.executeQuery("select * from employee where id="+c2.getSelectedItem());
            if(rs.next()){
                t1.setText(rs.getString("name"));
                t3.setText(rs.getString("address"));
                t4.setText(rs.getString("state"));
                t5.setText(rs.getString("city"));
                t6.setText(rs.getString("email"));
                t7.setText(rs.getString("phone"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static void main(String s[]){
        new update_employee();
    }

    
   
    
}

