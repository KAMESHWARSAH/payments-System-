
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
class splash {
    public static void main(String s[])
    {
       sframe f1= new sframe("payroll");
       f1.setVisible(true);
       int i;
       int x=1;
       for(i=2; i<=2100; i+=4, x+=1){
           f1.setLocation((800-((i+x)/2)),500-(i/2));
           f1.setSize(i+x,i);
           try{
               Thread.sleep(5);
               
           }catch(Exception e){
               
           }
       }
    }
    
    
}

class sframe extends JFrame implements Runnable{
    Thread th;
    sframe(String s){
        super(s);
        setLayout(new FlowLayout());
        ImageIcon c1= new ImageIcon(ClassLoader.getSystemResource("icon/payroll_system.jpg"));
        Image i1=c1.getImage().getScaledInstance(730,550,Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i1);
        JLabel m1=new JLabel(i2);
        add(m1);
        th=new Thread(this);
        th.start();
    }
    public void run(){
        try{
            Thread.sleep(5000);
            this.setVisible(false);
            login f1=new login();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
