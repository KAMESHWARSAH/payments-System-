
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class login extends JFrame implements ActionListener{
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    
    login (){
        super("Login page ");
        setLayout(new BorderLayout());
        t1=new JTextField(10);
        t2=new JPasswordField(10);
        JLabel l= new JLabel(new ImageIcon(ClassLoader.getSystemResource("icon\\defaultpic.png")));
        b1= new JButton("Submit",new ImageIcon(ClassLoader.getSystemResource("icon\\login.png")));
        b2= new JButton("Cancle",new ImageIcon(ClassLoader.getSystemResource("icon\\Cancel.png")));
        b1.addActionListener(this);
        b2.addActionListener(this);
        JPanel p1,p2,p3,p4,p5;
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        p5=new JPanel();
        
        ImageIcon c1=new ImageIcon("login.png");
        JLabel m1=new JLabel(c1);
        
        p1.add(m1);
        add(l,BorderLayout.WEST);
        
        p2.add(new JLabel("User Name"));
        p2.add(t1);
        p2.add(new JLabel("Password "));
        p2.add(t2);
        add(p2,BorderLayout.CENTER);
        
        p4.add(b1);
        p4.add(b2);
        add(p4,BorderLayout.SOUTH);
        
        
        
        
        
        setSize(350,300);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(600,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
     try{
         javaconnect c1=new javaconnect();
         String u=t1.getText();
         String v=t2.getText();
         String s= "select * from login where username='"+u+"' and password='"+v+"'";
         ResultSet rs=c1.stm.executeQuery(s);
         if(rs.next()){
             new project().setVisible(true);
            //JOptionPane.showMessageDialog(null,"Welcome");
            
             setVisible(false);
             
         }
         else{
             JOptionPane.showMessageDialog(null,"Invalid Login");
             setVisible(false);
             
         }
         
         
     }catch(Exception e){
         e.printStackTrace();
     }   
    }

    public static void main(String s[]){
        new login();
    }
    
    
}
