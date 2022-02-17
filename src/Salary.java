
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
import java.sql.ResultSet;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class Salary extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c2;
    
    Salary(){
        super("Set update");
        setSize(450,550);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setLocation(500,200);
        setVisible(true);
        getContentPane().setBackground(Color.white);
        
        //JPanel p1 = new JPanel();
        setBackground(Color.white);
        
        setLayout(new GridLayout(8,2,5,30));
        c2=new Choice();
        try{
            javaconnect  c = new javaconnect();
            ResultSet rs = c.stm.executeQuery("select * from employee");
            
            while(rs.next()){
                c2.add(rs.getString("id"));
            }
            
        }catch(Exception e){
            
        }
        
        add(new JLabel("Select Employee No"));
        add(c2);
        
        
        
        
        l1=new JLabel("HRA");
        t1=new JTextField(15);
        add(l1);
        add(t1);
        
        l3=new JLabel("DA");
        t3=new JTextField(15);
        add(l3);
        add(t3);
        
        l4=new JLabel("MED");
        t4=new JTextField(15);
        add(l4);
        add(t4);
        
        l5=new JLabel("PF");
        t5=new JTextField(15);
        add(l5);
        add(t5);
        
        l6=new JLabel("BASIC SALARY");
        t6=new JTextField(15);
        add(l6);
        add(t6);
        

        
        b1=new JButton("Submit");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        add(b1);
        
        b2=new JButton("Cancle");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
       add(b2);
        
       
        
        b1.addActionListener(this);
        b2.addActionListener(this);

       
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String hra=t1.getText();
        String id = c2.getSelectedItem();
        String da=t3.getText();
        String med=t4.getText();
        String pf=t5.getText();
        String basic=t6.getText();
        
        
        String qry ="insert into salary values('"+id+"','"+hra+"','"+da+"','"+med+"','"+pf+"','"+basic+"')";
        try{
           javaconnect ob= new javaconnect(); 
           ob.stm.executeUpdate(qry);
           JOptionPane.showMessageDialog(null,"Salary Update");
           this.setVisible(false);
        }catch(Exception ee){
            ee.printStackTrace();
        }
        
    }   
    public static void main(String s[]){
        new Salary();
    }
   
    
}

