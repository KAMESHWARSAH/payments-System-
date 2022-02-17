
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
public class ListAttendence extends JFrame implements ActionListener{
    JTable j1;
    JButton b1;
    String h[]={"Employee id", "Date Time", "First Half", "Second Half"};
    String d[][]=new String[15][4];
    int i=0, j=0;
    
    ListAttendence() throws SQLException{
    super("View Employee Attendence");
    //JTable t =new JTable(d,h);
    setSize(800,300);
    setLocation(450,150);
    String qry="select * from attendence";
    javaconnect c1= new javaconnect();
    ResultSet rs = c1.stm.executeQuery(qry);
    while(rs.next()){
        d[i][j++]=rs.getString("id");
        d[i][j++]=rs.getString("date_tm");
        d[i][j++]=rs.getString("f_half");
        d[i][j++]=rs.getString("s_half");
        
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
        new ListAttendence().setVisible(true);
        
    }
    
   
    
}
