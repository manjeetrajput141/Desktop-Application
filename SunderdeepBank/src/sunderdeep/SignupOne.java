package sunderdeep;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.sql.*;

public class SignupOne extends JFrame implements ActionListener {

    PreparedStatement s;
    JLabel name, fname, dob, email, address, city, state, marital, pin, gender;
    JRadioButton male, female, married, unmarried;
    JTextField nameTextField, fnameTextField, dobTextField, cityTextField,
            pinTextField,
            stateTextField, addressTextField, emailTextField;

    JButton next, back;
    Long formno;

    public SignupOne() {

        Random rand = new Random();
        formno = Math.abs((rand.nextLong() % 9000) + 1000);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/back.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 800);
        add(image);


        JLabel heading1 = new JLabel("Application Form :" + formno);
        heading1.setBounds(200, 10, 400, 40);
        heading1.setFont(new Font("Raleway", Font.BOLD, 30));
        image.add(heading1);

        JLabel formtype = new JLabel("Personal Details ");
        formtype.setBounds(100, 80, 300, 30);
        formtype.setFont(new Font("Raleway", Font.BOLD, 24));
        image.add(formtype);

        name = new JLabel("Name : ");
        name.setBounds(100, 130, 300, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(name);

        nameTextField = new JTextField();
        nameTextField.setBounds(300, 130, 300, 30);
        nameTextField.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(nameTextField);

        fname = new JLabel("Father Name : ");
        fname.setBounds(100, 180, 300, 30);
        fname.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setBounds(300, 180, 300, 30);
        fnameTextField.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(fnameTextField);

        dob = new JLabel("Date Of Birth : ");
        dob.setBounds(100, 230, 300, 30);
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(dob);

        dobTextField = new JTextField();
        dobTextField.setBounds(300, 230, 300, 30);
        dobTextField.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(dobTextField);

        email = new JLabel("Email");
        email.setBounds(100, 280, 300, 30);
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(300, 280, 300, 30);
        emailTextField.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(emailTextField);

        gender = new JLabel("Gender : ");
        gender.setBounds(100, 330, 300, 30);
        gender.setBackground(Color.WHITE);
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(gender);

        male = new JRadioButton("Male  ");
        male.setBounds(300, 330, 100, 30);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(male);

        female = new JRadioButton("Female  ");
        female.setBounds(450, 330, 200, 30);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        marital = new JLabel("Marital Status : ");
        marital.setBounds(100, 380, 300, 30);
        marital.setBackground(Color.WHITE);
        marital.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(marital);

        married = new JRadioButton("Married  ");
        married.setBounds(300, 380, 130, 30);
        married.setBackground(Color.WHITE);
        married.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(married);

        unmarried = new JRadioButton("Unmarried ");
        unmarried.setBounds(450, 380, 200, 30);
        unmarried.setBackground(Color.WHITE);
        unmarried.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(unmarried);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(married);
        bg1.add(unmarried);

        address = new JLabel("Address : ");
        address.setBounds(100, 430, 300, 30);
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(address);

        addressTextField = new JTextField();
        addressTextField.setBounds(300, 430, 300, 30);
        addressTextField.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(addressTextField);

        state = new JLabel("State : ");
        state.setBounds(100, 480, 300, 30);
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(state);

        stateTextField = new JTextField();
        stateTextField.setBounds(300, 480, 300, 30);
        stateTextField.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(stateTextField);

        city = new JLabel("City : ");
        city.setBounds(100, 530, 300, 30);
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(city);

        cityTextField = new JTextField();
        cityTextField.setBounds(300, 530, 300, 30);
        cityTextField.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(cityTextField);

        pin = new JLabel("Pin code: ");
        pin.setBounds(100, 580, 300, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        image.add(pin);

        pinTextField = new JTextField();
        pinTextField.setBounds(300, 580, 300, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 18));
        image.add(pinTextField);

        JCheckBox check = new JCheckBox("All the details should be filled according to AadharCard");
        check.setBounds(100, 630, 600, 30);
        check.setFont(new Font("Raleway", Font.BOLD, 18));
        check.setBackground(Color.WHITE);
        image.add(check);

        next = new JButton("Next");
        next.setBounds(500, 700, 100, 30);
        next.setFont(new Font("Arial", Font.BOLD, 18));
        next.setBackground(Color.BLUE);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        image.add(next);

        back = new JButton("back");
        back.setBounds(300, 700, 100, 30);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        image.add(back);

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

        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = dobTextField.getText();
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        String gender = null;
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
            
            if(name.isEmpty() || fname.isEmpty() || dob.isEmpty() || 
                    email.isEmpty() || address.isEmpty()||city.isEmpty()
                    ||gender==null||state.isEmpty()||pin.isEmpty() ||marital==null ){
            
                
                JOptionPane.showMessageDialog(null,"All Fields should be filled ");

            }
            else
            {
               
            try {

                Conn conn = new Conn();
                String query = "insert into signup value(?,?,?,?,?,?,?,?,?,?,?)";
                s = conn.c.prepareStatement(query);
                s.setString(2, name);
                s.setLong(1, formno);
                s.setString(3, fname);
                s.setString(4, dob);
                s.setString(5, email);
                s.setString(6, gender);
                s.setString(7, marital);
                s.setString(8, address);
                s.setString(9, state);
                s.setString(10, city);
                s.setString(11, pin);
                s.executeUpdate();

                setVisible(false);
                new SignupTwo(formno).setVisible(true);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            }

        }

        if (e.getSource() == back) {

            setVisible(false);
            Login l = new Login();
            l.setVisible(true);
        }

    }

}
