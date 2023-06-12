package employe_management_system23;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;


public class AddEmployee extends JFrame implements ActionListener {
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname, tffname,tfsalary, tfadd,tfphone, tfemail;
    JDateChooser dcdob;
    JComboBox cbEducation;
    JButton addDetails, back;
    JLabel labelempID;
    
    AddEmployee(){
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(450,30,500,60);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD, 25));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel lbname = new JLabel("Name");
        lbname.setBounds(200, 150, 150, 30);
        add(lbname);   
        tfname = new JTextField();
        tfname.setBounds(350,150,150,30);
        add(tfname);
        
        
        JLabel lbfname = new JLabel("Father's Name");
        lbfname.setBounds(700, 150, 150, 30);
        add(lbfname);
        tffname = new JTextField();
        tffname.setBounds(850,150,150,30);
        add(tffname);
        
        //DOB
        JLabel lbDob = new JLabel("Date of Birth");
        lbDob.setBounds(200, 200, 150, 30);
        add(lbDob);
        dcdob = new JDateChooser();
        dcdob.setBounds(350,200,150,30);
        add(dcdob);
        
        //Salary
        JLabel lbsalary = new JLabel("Salary");
        lbsalary.setBounds(700, 200, 150, 30);
        add(lbsalary);
        tfsalary = new JTextField();
        tfsalary.setBounds(850,200,150,30);
        add(tfsalary);
        
        // Address
        JLabel lbadd = new JLabel("Address");
        lbadd.setBounds(200, 250, 150, 30);
        add(lbadd);
        tfadd = new JTextField();
        tfadd.setBounds(350,250,150,30);
        add(tfadd);
        
        // Phone
        JLabel lbphone = new JLabel("Phone");
        lbphone.setBounds(700, 250, 150, 30);
        add(lbphone);
        tfphone = new JTextField();
        tfphone.setBounds(850,250,150,30);
        add(tfphone);
        
        // Email
        JLabel lbemail = new JLabel("Email");
        lbemail.setBounds(200, 300, 150, 30);
        add(lbemail);
        tfemail = new JTextField();
        tfemail.setBounds(350,300,150,30);
        add(tfemail);
        
        // Courses
        JLabel lbeducation = new JLabel("Highest Education");
        lbeducation.setBounds(700, 300, 150, 30);
        add(lbeducation);
        String Courses[] = {" ","BBA","BCA","BA","B.TECH","BBA","MCA","MBA","MA","MS","PHD","Others"};
        cbEducation = new JComboBox(Courses);
        cbEducation.setBackground(Color.WHITE);
        cbEducation.setBounds(850,300,150,30);
        add(cbEducation);
        
        // EmpID
        JLabel lbempID = new JLabel("EMployyee ID");
        lbempID.setBounds(200, 350, 150, 30);
        add(lbempID);
        
        labelempID = new JLabel("" + number);
        labelempID.setBounds(350,350,150,30);
        add(labelempID);
        
        // Button 
        
        addDetails = new JButton("Add Details");
        addDetails.setBounds(350, 400, 200, 50);
        addDetails.addActionListener(this);
        addDetails.setBackground(Color.BLACK);
        addDetails.setForeground(Color.WHITE);
        add(addDetails);
        
        back = new JButton("Back");
        back.setBounds(650, 400, 200, 50);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        
        setSize(1200, 650);
        setLocation(200, 70);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == addDetails){
          
          String name = tfname.getText();
          String fname = tffname.getText();
          String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
          String salary = tfsalary.getText();
          String address = tfadd.getText();
          String phone = tfphone.getText();
          String email = tfemail.getText();
          String education = (String) cbEducation.getSelectedItem();
          String empId = labelempID.getText();
          System.out.println(empId);
            
          try{
              Conn conn = new Conn();
              String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+address+"', '"+salary+"', '"+education+"', '"+phone+"', '"+email+"', '"+empId+"')";
              conn.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "Details Addedd");
              setVisible(false);
              new Home();
              
          }catch (Exception e){
              System.out.println(e);
              e.printStackTrace();
          }
    }else {
          setVisible(false);
          new Home();
      }
    }
    public static void main(String args[]){
        new AddEmployee();
    }
}
