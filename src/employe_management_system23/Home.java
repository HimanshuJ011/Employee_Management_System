package employe_management_system23;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    JButton add, view, update;
    
    Home(){
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1200, 650);
        add(image);
        
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(650,20,400,50);
        heading.setForeground(Color.darkGray);
        heading.setFont(new Font("Raleway",Font.BOLD, 25));
        image.add(heading);
        
        // Buttons 
         add = new JButton("Add Employee");
         add.setBounds(650, 80, 200,40);
         add.addActionListener(this);
         image.add(add);
         
         view = new JButton("View Details");
         view.setBounds(900, 140, 200,40);
         view.addActionListener(this);
         image.add(view);
         
         
         update = new JButton("Update Employee");
         update.setBounds(650, 140, 200,40);
         update.addActionListener(this);
         image.add(update);
         
         JButton remove = new JButton("Remove Employee");
         remove.setBounds(900, 80, 200,40);
         remove.addActionListener(this);
         image.add(remove);
         
         
        setSize(1200, 650);
        setLocation(200, 70);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == add){
          setVisible(false);
          new AddEmployee();
      }else  if(ae.getSource() == view){
          setVisible(false);

           new ViewEmployee();
      }
      else  if(ae.getSource() == update){     
           setVisible(false);
           new ViewEmployee();
      }else{
          new RemoveEmployee();
      }
    }
   
    public static void main(String args[]){
        Home home = new Home();
    }
}