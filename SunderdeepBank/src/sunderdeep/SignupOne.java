package sunderdeep;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.sql.*;

public class SignupOne extends JFrame implements ActionListener {

    PreparedStatement s;
    JLabel name, fname, dob, salary, address, city, state, marital, pin, gender;
    JRadioButton male, female, married, unmarried;
    JTextField nameTextField, fnameTextField, dobTextField, cityTextField,
            pinTextField,
            stateTextField, addressTextField, salaryTextField;

    JButton next, back;
    Long formno;

    public SignupOne() {

        Random rand = new Random();
        formno = Math.abs((rand.nextLong() % 9000) + 1000);

        JLabel heading1 = new JLabel("Application Form :" + formno);
        heading1.setBounds(200, 10, 400, 40);
        heading1.setFont(new Font("Raleway", Font.BOLD, 30));
        add(heading1);

        JLabel formtype = new JLabel("Personal Details ");
        formtype.setBounds(100, 80, 300, 30);
        formtype.setFont(new Font("Raleway", Font.BOLD, 24));
        add(formtype);

        name = new JLabel("Name : ");
        name.setBounds(100, 130, 300, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        add(name);

        nameTextField = new JTextField();
        nameTextField.setBounds(300, 130, 300, 30);
        nameTextField.setFont(new Font("Arial", Font.BOLD, 18));
        add(nameTextField);

        fname = new JLabel("Father Name : ");
        fname.setBounds(100, 180, 300, 30);
        fname.setFont(new Font("Raleway", Font.BOLD, 18));
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setBounds(300, 180, 300, 30);
        fnameTextField.setFont(new Font("Arial", Font.BOLD, 18));
        add(fnameTextField);

        dob = new JLabel("Date Of Birth : ");
        dob.setBounds(100, 230, 300, 30);
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        add(dob);

        dobTextField = new JTextField();
        dobTextField.setBounds(300, 230, 300, 30);
        dobTextField.setFont(new Font("Arial", Font.BOLD, 18));
        add(dobTextField);

        salary = new JLabel("Salary : ");
        salary.setBounds(100, 280, 300, 30);
        salary.setFont(new Font("Raleway", Font.BOLD, 18));
        add(salary);

        salaryTextField = new JTextField();
        salaryTextField.setBounds(300, 280, 300, 30);
        salaryTextField.setFont(new Font("Arial", Font.BOLD, 18));
        add(salaryTextField);

        gender = new JLabel("Gender : ");
        gender.setBounds(100, 330, 300, 30);
        gender.setBackground(Color.WHITE);
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        add(gender);

        male = new JRadioButton("Male  ");
        male.setBounds(300, 330, 100, 30);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Raleway", Font.BOLD, 18));
        add(male);

        female = new JRadioButton("Female  ");
        female.setBounds(450, 330, 200, 30);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Raleway", Font.BOLD, 18));
        add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        marital = new JLabel("Marital Status : ");
        marital.setBounds(100, 380, 300, 30);
        marital.setBackground(Color.WHITE);
        marital.setFont(new Font("Raleway", Font.BOLD, 18));
        add(marital);

        married = new JRadioButton("Married  ");
        married.setBounds(300, 380, 130, 30);
        married.setBackground(Color.WHITE);
        married.setFont(new Font("Raleway", Font.BOLD, 18));
        add(married);

        unmarried = new JRadioButton("Unmarried ");
        unmarried.setBounds(450, 380, 200, 30);
        unmarried.setBackground(Color.WHITE);
        unmarried.setFont(new Font("Raleway", Font.BOLD, 18));
        add(unmarried);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(married);
        bg1.add(unmarried);

        address = new JLabel("Address : ");
        address.setBounds(100, 430, 300, 30);
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        add(address);

        addressTextField = new JTextField();
        addressTextField.setBounds(300, 430, 300, 30);
        addressTextField.setFont(new Font("Arial", Font.BOLD, 18));
        add(addressTextField);

        state = new JLabel("State : ");
        state.setBounds(100, 480, 300, 30);
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        add(state);

        stateTextField = new JTextField();
        stateTextField.setBounds(300, 480, 300, 30);
        stateTextField.setFont(new Font("Arial", Font.BOLD, 18));
        add(stateTextField);

        city = new JLabel("City : ");
        city.setBounds(100, 530, 300, 30);
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        add(city);

        cityTextField = new JTextField();
        cityTextField.setBounds(300, 530, 300, 30);
        cityTextField.setFont(new Font("Arial", Font.BOLD, 18));
        add(cityTextField);

        pin = new JLabel("Pin code: ");
        pin.setBounds(100, 580, 300, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        add(pin);

        pinTextField = new JTextField();
        pinTextField.setBounds(300, 580, 300, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 18));
        add(pinTextField);

        JCheckBox check = new JCheckBox("All the details should be filled according to AadharCard");
        check.setBounds(100, 630, 600, 30);
        check.setFont(new Font("Raleway", Font.BOLD, 18));
        check.setBackground(Color.WHITE);
        add(check);

        next = new JButton("Next");
        next.setBounds(500, 700, 100, 30);
        next.setFont(new Font("Arial", Font.BOLD, 18));
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        back = new JButton("back");
        back.setBounds(300, 700, 100, 30);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setLayout(null);
        setSize(750, 800);
        setLocation(300, 10);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new SignupOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name=null,fname=null,dob=null,salary=null,address=null,city=null,
                state=null,pin=null,gender=null;

        name = nameTextField.getText();
        fname = fnameTextField.getName();
        dob = dobTextField.getText();
         salary = salaryTextField.getText();
         address = addressTextField.getText();
        city = cityTextField.getText();
         state = stateTextField.getText();
         pin = pinTextField.getText();
         gender = null;
        if (male.isSelected()) {
            gender = "Male";

        } else if (female.isSelected()) {
            gender = "Female";
        }
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";

        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        }

//        --------------------------------------------------------------------
        if (e.getSource() == next) {
          try
          {
              
          
            Conn conn=new Conn();
            String query="insert into signup value(?,?,?,?,?,?,?,?,?,?,?)";
            s=conn.c.prepareStatement(query);
            s.setString(2, name);
            s.setLong(1, formno);
            s.setString(3, fname);
            s.setString(4, dob);
            s.setString(5, salary);
            s.setString(6, gender);
            s.setString(7, marital);
            s.setString(8, address);
            s.setString(9, state);
            s.setString(10, city);
            s.setString(11, pin);
            s.executeUpdate();
            
            
            
          }
          catch(Exception ex)
          {
              ex.printStackTrace();
          }
            
        }

        if (e.getSource() == back) {

            setVisible(false);
            Login l = new Login();
            l.setVisible(true);
        }

    }

}
