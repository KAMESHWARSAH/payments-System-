
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class Update_salary  extends JFrame implements ActionListener,ItemListener {
   JLabel l1,l2,l3,l4,l5,l6;
   JTextField t1,t2,t3,t4,t5,t6;
   JButton b1,b2;
   Choice c2;
    Update_salary() {
      setLayout(null);
      c2 = new Choice();
      try{
            javaconnect  c = new javaconnect();
            ResultSet rs = c.stm.executeQuery("select * from employee");
            
            while(rs.next()){
                //c2.addItem(rs.getString("id"));
                c2.add(rs.getString("id"));
            }
            
        }catch(Exception e){
            
        }
      JLabel emp = new JLabel("select Employee no");
      emp.setBounds(20,20,100,20);
      add(emp);
      
      c2.setBounds(120,20,200,20);
      add(c2);
      
      l1= new JLabel("hra");
      t1=new JTextField(15);
      
      l1.setBounds(20, 60,100,20);
      t1.setBounds(120,60, 200,20);
      
      add(l1);
      add(t1);
      
     l2= new JLabel("da");
     t2=new JTextField(15);
     l2.setBounds(20, 100,100,20);
     t2.setBounds(120,100, 200,20);
     add(l2);
     add(t2);
     
     l3= new JLabel("med");
     t3=new JTextField(15);
     l3.setBounds(20, 140,100,20);
     t3.setBounds(120,140, 200,20);
     add(l3);
     add(t3);
     
     l4= new JLabel("pf");
     t4=new JTextField(15);
     l4.setBounds(20, 180,100,20);
     t4.setBounds(120,180, 200,20);
     add(l4);
     add(t4);
      
     l5= new JLabel("basic_salary");
     t5=new JTextField(15);
     l5.setBounds(20, 220,100,20);
     t5.setBounds(120,220, 200,20);
     add(l5);
     add(t5);
     
     b1.setBounds(40,200,100,20);
     b2.setBounds(200,200,100,20);
     
     
     b1=new JButton("Update");
     b1.setBackground(Color.BLACK);
     b1.setForeground(Color.WHITE);
     add(b1);
     
     b2=new JButton("Delate");
     b2.setBackground(Color.BLACK);
     b2.setForeground(Color.WHITE);
     add(b2);
     b1.addActionListener(this);
     b2.addActionListener(this);
     //c2.addItemListener(this);
     getContentPane().setBackground(Color.WHITE);
     
     setVisible(true);
     setSize(400,450);
     setLocation(600,200);
   }
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==b1){
        String hra=t1.getText();
        String id=c2.getSelectedItem();
        String da=t2.getText();
        String med=t3.getText();
        String pf=t4.getText();
        String basic=t5.getText();
        
      String qry="update salary set hra="+hra+",da="+da+", med="+med+", pf="+pf+", basic_salary="+basic+" where id="+c2.getSelectedItem()+"";
        
        try{
            javaconnect c1 =new javaconnect();
            c1.stm.executeUpdate(qry);
            JOptionPane.showMessageDialog(null,"Salary Update");
            this.setVisible(false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    if(ae.getSource()==b2){
        try{
            javaconnect c1 =new javaconnect();
            c1.stm.executeUpdate("delete from salary where id="+c2.getSelectedItem());
            JOptionPane.showMessageDialog(null,"Salary Deleted");
            this.setVisible(false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
public void itemStateChaged(ItemEvent ie){
    try{
        javaconnect c1= new javaconnect();
        ResultSet rs= c1.stm.executeQuery("select * from salary where id="+c2.getSelectedItem());
        if(rs.next()){
            t1.setText(rs.getString("hra"));
            t2.setText(rs.getString("da"));
            t3.setText(rs.getString("med"));
            t4.setText(rs.getString("pf"));
            t5.setText(rs.getString("basic_salary"));
            
            
        }
    }catch(Exception e){
        e.printStackTrace();
    }    
    }
    

    
    public static void main(String s[]) throws SQLException{
        new Update_salary();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
   