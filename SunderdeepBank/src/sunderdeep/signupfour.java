package sunderdeep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class signupfour extends JFrame implements ActionListener {

    PreparedStatement ps;

    JButton deposit, back;
    String pinnumber, cardnumber;
    JTextField amount;

    signupfour(String cardnumber, String pinnumber) {
        this.cardnumber = cardnumber;
        this.pinnumber = pinnumber;

        // JOptionPane.showMessageDialog(null,"Card Number'"+cardnumber+"'Pin :'"+pinnumber+"'");
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/ULogo.png"));
        Image icon2 = icon1.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel label = new JLabel(icon3);
        label.setBounds(200, 40, 120, 120);
        image.add(label);

        JLabel heading = new JLabel(" Sunderdeep Bank ATM");
        heading.setBounds(350, 60,400, 90);
        heading.setFont(new Font("Raleway", Font.BOLD, 30));
        image.add(heading);

        JLabel header = new JLabel("You have to Add Min Amount 1000 ");

        header.setBounds(190, 280, 300, 30);
        header.setFont(new Font("System", Font.BOLD, 16));
        header.setForeground(Color.WHITE);
        image.add(header);

        JLabel header2 = new JLabel("For Succefully Open an Account");

        header2.setBounds(190, 320, 300, 30);
        header2.setFont(new Font("System", Font.BOLD, 16));
        header2.setForeground(Color.WHITE);
        image.add(header2);

        amount = new JTextField();
        amount.setBounds(190, 360, 250, 30);
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setFont(new Font("System", Font.BOLD, 16));
        deposit.setBounds(360, 460, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setFont(new Font("System", Font.BOLD, 16));
        back.setBounds(360, 490, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new SignupThree(5L).setVisible(true);
        }
        if (ae.getSource() == deposit) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));

            String a = amount.getText();
            String mode = "Deposit";
            String transaction = "Insert into bank values('" + cardnumber + "','" + pinnumber + "','" + a + "','" + a + "','" + now + "','" + mode + "')";

            try {
                Conn conn = new Conn();
                ps = conn.c.prepareStatement(transaction);
                ps.executeUpdate();

            } catch (SQLException e) {
                System.out.print(e);
            }
            setVisible(false);
        }
    }

    public static void main(String args[]) {
        new signupfour("", "");
    }

}
