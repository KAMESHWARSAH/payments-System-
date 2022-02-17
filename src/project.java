
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class project extends JFrame implements ActionListener{
    project(){
        //setSize(2150,11000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hopital.jpg"));
        Image i2 = i1.getImage().getScaledInstance(2020,700,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel l1= new JLabel(i3);
        add(l1);
        
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        JMenu m1 = new JMenu("Master");
        m1.setForeground(Color.blue);
        
        JMenuItem t1 = new JMenuItem("New Employee");
        t1.setForeground(Color.blue);
        t1.setFont(new Font("monospaced ", Font.PLAIN,20));
        t1.setMnemonic('N');
        t1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
        t1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        
        JMenuItem t3 =new JMenuItem("Salary");
        t3.setForeground(Color.blue);
        t3.setFont(new Font("monospaced", Font.PLAIN,20));
        t3.setMnemonic('s');
        t3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
        t3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        
        JMenuItem t4 = new JMenuItem("List Employee");
        t4.setForeground(Color.blue);
        t4.setFont(new Font("monospaced", Font.PLAIN,12));
        t4.setMnemonic('L');
        t4.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
        t4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        
        m1.add(t1);
        //m1.add(t2);
        m1.add(t3);
        m1.add(t4);
        mb.add(m1);
        
        t1.addActionListener(this);
        //t2.addActionListener(this);
        t3.addActionListener(this);
        t4.addActionListener(this);
        
        JMenu edit = new JMenu("Update");
        edit.setForeground(Color.red);
        mb.add(edit);
        JMenuItem s1=new JMenuItem("Update salary");
        s1.setForeground(Color.blue);
        s1.setFont(new Font("monospaced", Font.PLAIN,12));
        s1.setMnemonic('U');
        s1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
        s1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
        edit.add(s1);
        
        JMenuItem s2=new JMenuItem("Update Employee");
        s2.setForeground(Color.blue);
        s2.setFont(new Font("monospaced", Font.PLAIN,12));
        s2.setMnemonic('P');
        s2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
        s2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        edit.add(s2);
        
        
        JMenuItem s3=new JMenuItem("Take Attendence");
        s3.setForeground(Color.blue);
        s3.setFont(new Font("monospaced", Font.PLAIN,12));
        s3.setMnemonic('T');
        s3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
        s3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.CTRL_MASK));
        edit.add(s3);
        
        s1.addActionListener(this);
        s2.addActionListener(this);
        s3.addActionListener(this);
        //s4.addActionListener(this);
        
        JMenu rep = new JMenu("Reports");
        edit.setForeground(Color.blue);
        mb.add(rep);
        
        JMenuItem p1=new JMenuItem("Generate Payslip");
        p1.setForeground(Color.blue);
        p1.setFont(new Font("monospaced", Font.PLAIN,12));
        p1.setMnemonic('P');
        p1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
        p1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        rep.add(p1);
        
        JMenuItem p2=new JMenuItem("List Attendence");
        p2.setForeground(Color.blue);
        p2.setFont(new Font("monospaced", Font.PLAIN,12));
        p2.setMnemonic('L');
        p2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
        p2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
        rep.add(p2);
        
        p1.addActionListener(this);
        p2.addActionListener(this);
        
        JMenu utli = new JMenu("Utilities");
        edit.setForeground(Color.red);
        mb.add(utli);
        
        JMenuItem u1=new JMenuItem("Notepad");
        u1.setForeground(Color.blue);
        u1.setFont(new Font("monospaced", Font.PLAIN,12));
        u1.setMnemonic('N');
        u1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        utli.add(u1);
        
        JMenuItem u2=new JMenuItem("Calculator");
        u2.setForeground(Color.blue);
        u2.setFont(new Font("monospaced", Font.PLAIN,12));
        u2.setMnemonic('C');
        u2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
        u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        utli.add(u2);
        
        JMenuItem u3=new JMenuItem("Web Browser");
        u3.setForeground(Color.blue);
        u3.setFont(new Font("monospaced", Font.PLAIN,12));
        u3.setMnemonic('W');
        u3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.PNG")));
        u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
        utli.add(u3);
        
        u1.addActionListener(this);
        u2.addActionListener(this);
        u2.addActionListener(this);
        
        JMenu m8 = new JMenu("Exit");
        m8.setForeground(Color.red);
        mb.add(m8);
        
        JMenuItem m8il=new JMenuItem("Exit");
        m8il.setForeground(Color.blue);
        m8il.setFont(new Font("monospaced", Font.PLAIN,12));
        m8il.setMnemonic('X');
        m8il.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.png")));
        m8il.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        m8.add(m8il);
        m8il.addActionListener(this);
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
        String msg= ae.getActionCommand();
       if(msg.equals("New Employee"))
           new New_Employee().setVisible(true);
       else if(msg.equals("List Employee"))
           try {
               new List_Employee().setVisible(true);
               
        
        
        } catch (SQLException ex) {
            Logger.getLogger(project.class.getName()).log(Level.SEVERE, null, ex);
        }
      else if(msg.equals("Salary"))
          new Salary().setVisible(true);
       
      else if(msg.equals("Update Employee"))
              new update_employee().setVisible(true);
      else if(msg.equals("Update salary"))
          new salary_update().setVisible(true);
       else if(msg.equals("Notepad"))
          try{
            Runtime.getRuntime().exec("notepad.exe");
          }catch(Exception e){
              
          }
        else if(msg.equals("Calculator"))
          try{
            Runtime.getRuntime().exec("calc.exe");
          }catch(Exception e){
              
          }
        else if(msg.equals("Web Browser"))
          try{
            Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
          }catch(Exception e){
              
          }
       else if(msg.equals("Take Attendence"))
           new TakeAttendence().setVisible(true);
       else if(msg.equals("List Attendence"))
           try {
               new ListAttendence().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(project.class.getName()).log(Level.SEVERE, null, ex);
        }
       else if(msg.equals("Exit"))
          // dispose();
          System.exit(0);
       else if(msg.equals("Generate Payslip"))
          new Payslip().setVisible(true);
       
           
       
    }
    public static void main(String ar[]){
        new project().setVisible(true);
    }

   
    
}
