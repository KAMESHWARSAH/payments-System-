
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class List_Employee extends JFrame implements ActionListener{
    JTable j1;
    JButton b1;
    String h[]={"id","name","gender","address","state","city","email","phone"};
    String d[][]=new String[20][8];
    int i=0, j=0;
    
    List_Employee() throws SQLException{
    super("View Employee List");
    //JTable t =new JTable(d,h);
    setSize(1000,400);
    setLocation(450,200);
    String qry="select * from employee";
    javaconnect c1= new javaconnect();
    ResultSet rs = c1.stm.executeQuery(qry);
    while(rs.next()){
        d[i][j++]=rs.getString("id");
        d[i][j++]=rs.getString("name");
        d[i][j++]=rs.getString("gender");
        d[i][j++]=rs.getString("address");
        d[i][j++]=rs.getString("state");
        d[i][j++]=rs.getString("city");
        d[i][j++]=rs.getString("email");
        d[i][j++]=rs.getString("phone");
        i++;
        j=0;
    }
    j1=new JTable(d,h);
    
    try{
        
    }catch(Exception e){
        e.printStackTrace();
    }
    b1=new JButton("Print");
    add(b1,"South");
    JScrollPane s1=new JScrollPane(j1);
    add(s1);
    b1.addActionListener(this);
    
}
    public void actionPerformed(ActionEvent ae){
        try{
           j1.print();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String s[]) throws SQLException
    {
        new List_Employee().setVisible(true);
        
    }
    
   
    
}
