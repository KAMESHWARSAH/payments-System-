
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


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class New_Employee extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c1;
    
    New_Employee(){
        super("New Employee");
        setSize(650,600);
        setLocation(600,200);
        getContentPane().setBackground(Color.white);
        
        JPanel p1 = new JPanel();
        p1.setBackground(Color.white);
        
        p1.setLayout(new GridLayout(8,2,10,40));
        l1=new JLabel("Name");
        t1=new JTextField(15);
        p1.add(l1);
        p1.add(t1);
        
        c1=new Choice();
        c1.add("Male");
        c1.add("Female");
        
        l2=new JLabel("Gender");
        p1.add(l2);
        p1.add(c1);
        
        l3=new JLabel("Address");
        t3=new JTextField(15);
        p1.add(l3);
        p1.add(t3);
        
        l4=new JLabel("State");
        t4=new JTextField(15);
        p1.add(l4);
        p1.add(t4);
        
        l5=new JLabel("City");
        t5=new JTextField(15);
        p1.add(l5);
        p1.add(t5);
        
        l6=new JLabel("Email");
        t6=new JTextField(15);
        p1.add(l6);
        p1.add(t6);
        
        l7=new JLabel("Phone ");
        t7=new JTextField(15);
        p1.add(l7);
        p1.add(t7);
        
        b1=new JButton("Submit");
        b2=new JButton("Cancle");
       p1.add(b1);
        p1.add(b2);
        setLayout(new BorderLayout());
        setLayout(new BorderLayout());
        
       add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon/exit.png"))));
        add(p1);
        
        b1.addActionListener(this);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        
        b2.addActionListener(this);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
       
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==b1){
        String n=t1.getText();
        String g = c1.getSelectedItem();
        String a=t3.getText();
        String s=t4.getText();
        String c=t5.getText();
        String e=t6.getText();
        String p=t7.getText();
        
        String qry ="insert into employee values(null,'"+n+"','"+g+"','"+a+"','"+s+"','"+c+"','"+e+"','"+p+"')";
        try{
           javaconnect ob= new javaconnect(); 
           ob.stm.executeUpdate(qry);
           JOptionPane.showMessageDialog(null,"Employee Created");
           
        }catch(Exception ee){
            ee.printStackTrace();
        }   
       }
       if(ae.getSource()==b2){
           
       }
        
        
    }   
    public static void main(String s[]){
        new New_Employee().setVisible(true);
    }
   
    
}

