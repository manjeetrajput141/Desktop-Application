
package sunderdeep;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    JLabel cardText, pin;
    JTextField cardTextField;
    JPasswordField pinTextField;
    JButton login, reset, signup;

    Login() {
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i.getImage().getScaledInstance(100, 100, 60);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(50, 25, 300, 100);
        add(img);

        JLabel heading1 = new JLabel("Welcome to ");
        heading1.setBounds(380, 10, 300, 80);
        heading1.setFont(new Font("Raleway", Font.BOLD, 30));
        add(heading1);

        JLabel heading = new JLabel(" Sunderdeep Bank");
        heading.setBounds(330, 60, 300, 90);
        heading.setFont(new Font("Raleway", Font.BOLD, 30));
        add(heading);

        cardText = new JLabel(" Card No :");
        cardText.setBounds(200, 170, 200, 30);
        cardText.setFont(new Font("OSWALD", Font.BOLD, 24));
        add(cardText);

        cardTextField = new JTextField();
        cardTextField.setBounds(400, 170, 240, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 18));
        add(cardTextField);

        pin = new JLabel(" PIN         :");
        pin.setBounds(200, 220, 200, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 24));
        add(pin);
        pinTextField = new JPasswordField();
        pinTextField.setBounds(400, 220, 240, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 18));
        add(pinTextField);

        login = new JButton("Login");
        login.setBounds(400, 270, 100, 30);
        login.setFont(new Font("Raleway", Font.PLAIN, 16));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);

        reset = new JButton("Cancel");
        reset.setBounds(540, 270, 100, 30);
        reset.setFont(new Font("Raleway", Font.PLAIN, 16));
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.addActionListener(this);
        add(reset);

        signup = new JButton("Sign Up");
        signup.setBounds(400, 320, 240, 30);
        signup.setFont(new Font("Raleway", Font.PLAIN, 16));
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        setLayout(null);
        setSize(800, 450);
        setLocation(300, 200);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {

        } else if (e.getSource() == reset) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (e.getSource() == signup) {
            
            setVisible(false);
            SignupOne signup=new SignupOne();
            signup.setVisible(true);

        }

    }

    public static void main(String[] args) {
        new Login();
    }

}
