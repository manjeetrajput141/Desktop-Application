package sunderdeep;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel cardText, pin;
    JTextField cardTextField;
    JPasswordField pinTextField;
    JButton login, reset, signup;
    String username;

    Login() {
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2 = i.getImage().getScaledInstance(900, 900, 60);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 800, 450);
        add(img);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ULogo.png"));
        Image icon2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel label = new JLabel(icon3);
        label.setBounds(250, 10, 150, 150);
        img.add(label);

        JLabel heading1 = new JLabel("Welcome to ");
        heading1.setBounds(450, 10, 300, 80);
        heading1.setFont(new Font("Raleway", Font.BOLD, 28));
        img.add(heading1);

        JLabel heading = new JLabel(" Sunderdeep Bank");
        heading.setBounds(400, 60, 300, 90);
        heading.setFont(new Font("Raleway", Font.BOLD, 28));
        img.add(heading);

        cardText = new JLabel(" Card No :");
        cardText.setBounds(300, 170, 200, 30);
        cardText.setFont(new Font("OSWALD", Font.BOLD, 24));
        img.add(cardText);

        cardTextField = new JTextField();
        cardTextField.setBounds(500, 170, 240, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 18));
        img.add(cardTextField);

        pin = new JLabel(" PIN         :");
        pin.setBounds(300, 220, 200, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 24));
        img.add(pin);
        pinTextField = new JPasswordField();
        pinTextField.setBounds(500, 220, 240, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 18));
        img.add(pinTextField);

        login = new JButton("Login");
        login.setBounds(500, 270, 100, 30);
        login.setFont(new Font("Raleway", Font.PLAIN, 16));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        img.add(login);

        reset = new JButton("Cancel");
        reset.setBounds(640, 270, 100, 30);
        reset.setFont(new Font("Raleway", Font.PLAIN, 16));
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.addActionListener(this);
        img.add(reset);

        signup = new JButton("Sign Up");
        signup.setBounds(500, 320, 240, 30);
        signup.setFont(new Font("Raleway", Font.PLAIN, 16));
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        img.add(signup);

        setLayout(null);
        setSize(800, 450);
        setLocation(300, 200);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {
            String cardNumber = cardTextField.getText();
            long pinNumber = Long.parseLong(pinTextField.getText());

            Conn conn = new Conn();
            String query = "select * from login where cardnumber=? and pinnumber=?";
            try {
                PreparedStatement ps = conn.c.prepareStatement(query);
                ps.setString(1, cardNumber);
                ps.setLong(2, pinNumber);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int formno = rs.getInt("formno");
                    System.out.println("Form No: " + formno);
                    String q = "select * from signup where formno=?";
                    PreparedStatement pstmt = conn.c.prepareStatement(q);
                    pstmt.setInt(1, formno);
                    ResultSet result = pstmt.executeQuery();
                    if (result.next()) {
                        this.username = result.getString("name");
                        //        System.out.println(username);
                        //    System.out.println("There is result ");
                    }
                    setVisible(false);
                    new Transcation(username, cardNumber, pinNumber)
                            .setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == reset) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (e.getSource() == signup) {

            setVisible(false);
            SignupOne signup = new SignupOne();
            signup.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
