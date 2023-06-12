package employe_management_system23;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JTextField tfUSername,tfPassword;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Username 
        JLabel lbUsername = new JLabel("Username");
        lbUsername.setBounds(50, 20, 100, 30);
        add(lbUsername);
        
        // Username Text Field
         tfUSername = new JTextField();
        tfUSername.setBounds(160,20,160,30);
        add(tfUSername);
        
        //Password
        JLabel lbPassword = new JLabel("Password");
        lbPassword.setBounds(50, 100, 100, 30);
        add(lbPassword);
        
        // Password Text field
        tfPassword = new JTextField();
        tfPassword.setBounds(160,100,160,30);
        add(tfPassword);
        
        // Button
        JButton login = new JButton("LOGIN");
        login.setBounds(160, 170, 160, 30);
        login.setBackground(Color.GREEN);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        // Image on the login page
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(170, 170, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 2, 200, 200);
        add(image);
        
        setSize(600, 400);
        setLocation(450, 200);
        setVisible(true);
    }
      public void actionPerformed(ActionEvent ae){
          try{
              String username = tfUSername.getText();
              String password = tfPassword.getText();
              Conn c = new Conn();
              String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
              
            ResultSet rs =   c.s.executeQuery(query);
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Invalid username and Password");
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Success");
                setVisible(false);
            }
            new Home();
          }catch(Exception e){
          }
    }
    public static void main(String args[]){
        new Login();
    }
}


// jdbc:mysql://127.0.0.1:3306/?user=root