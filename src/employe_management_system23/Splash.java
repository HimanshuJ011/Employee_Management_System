package employe_management_system23;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener{
    Splash(){
        getContentPane().setBackground(Color.WHITE); //  make backg White in Color
        setLayout(null);
        
        // Heading
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(300,30,1200,60);
        heading.setFont(new Font("serif",Font.PLAIN, 50));
        heading.setForeground(Color.RED);
        add(heading);
        
        // Front Page Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(70, 100, 1050, 500);
        add(image);
        
        //Button
        JButton clickhere = new JButton("CLICK HERE TO CONTI...");
        clickhere.setBounds(400, 400, 300, 70);
        clickhere.setBackground(Color.BLUE);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);
        image.add(clickhere);
         
        
        setSize(1200, 650);
        setLocation(200, 70);
        setVisible(true);
        
        while(true){
            heading.setVisible(false);
              try{
                  Thread.sleep(700);
              }catch (Exception e){
                  
              }
               heading.setVisible(true);
                  try{
                  Thread.sleep(700);
              }catch (Exception e){     
        }
        }
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    public static void main(String args[]){
        new Splash();
    }
       
}
