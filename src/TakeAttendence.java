
import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class TakeAttendence extends JFrame implements  ActionListener {
   JLabel l1,l2,l3,l4,l5,l6,l7,emp;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c2,fh,sh;
    TakeAttendence(){
        
        setLayout(new GridLayout(4,2,50,50));
        c2= new Choice();
        try{
            javaconnect  c = new javaconnect();
            ResultSet rs = c.stm.executeQuery("select * from employee");
            while(rs.next()){
                //c2.addItem(rs.getString("id"));
                c2.add(rs.getString("id"));
                //System.out.println("id is"+c2);
            }
            
        }catch(Exception e){
            
        }
        
        add(new JLabel("select Employee"));
        add(c2);
        
        l1=new JLabel("First Half");
        fh=new Choice();
        fh.add("Present");
        fh.add("Absent");
        fh.add("Leave");
        add(l1);
        add(fh);
        
        l2=new JLabel("Second Half");
        sh=new Choice();
        sh.add("Present");
        sh.add("Absent");
        sh.add("Leave");
        add(l2);
        add(sh);
        
      b1=new JButton("Submit");
      b1.setBackground(Color.BLACK);
      b1.setForeground(Color.white);
      
      b2=new JButton("Cancel");
      b1.setBackground(Color.BLACK);
      b1.setForeground(Color.white);
      
      add(b1);
      add(b2);
      b1.addActionListener(this);
      b2.addActionListener(this);
      
      getContentPane().setBackground(Color.white);
      
      setVisible(true);
      setSize(400,500);
      setLocation(600,200);
      
        
        
    }
    
   public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==b1){
        String f = fh.getSelectedItem();
      String s = sh.getSelectedItem();
      String dt=new java.util.Date().toString();
      String id= c2.getSelectedItem();
      String qry="insert into attendence values("+id+", '"+dt+"','"+f+"','"+s+"')";
      try{
          javaconnect c1= new javaconnect();
          c1.stm.executeUpdate(qry);
          JOptionPane.showMessageDialog(null,"Attendence Confirmed");
          this.setVisible(false);
      }catch(Exception ee){
          ee.printStackTrace();
      }
          
      }
       
      if(ae.getSource()==b2){
          new project().setVisible(true);
      }
           
           
       }
       
     
    public static void main(String s[]){
    new TakeAttendence(); 
    
    } 
        
} 
    
    

