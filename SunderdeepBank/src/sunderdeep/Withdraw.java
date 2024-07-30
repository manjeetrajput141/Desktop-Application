package sunderdeep;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

import java.time.format.DateTimeFormatter;

import java.time.LocalDateTime;
import java.util.Random;

public class Withdraw extends JFrame implements ActionListener {

    Statement s,s2;
    JButton withdraw, back;
    JTextField amountText;
    Long pinnumber;
    String cardnumber, username;
    int balance;

    Withdraw(String username, String cardnumber, Long pinnumber) {
        this.username = username;
        this.pinnumber = pinnumber;
        this.cardnumber = cardnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 850);
        add(image);
        JLabel t = new JLabel("Please Enter Amount:");
        t.setBounds(210, 280, 300, 30);
        t.setFont(new Font("System", Font.BOLD, 16));
        t.setForeground(Color.WHITE);
        image.add(t);

        amountText = new JTextField();
        amountText.setFont(new Font("Raleway", Font.BOLD, 22));
        amountText.setBounds(150, 330, 350, 30);
        image.add(amountText);

        withdraw = new JButton("Withdraw");
        withdraw.setFont(new Font("System", Font.BOLD, 16));
        withdraw.setBounds(360, 440, 150, 30);
        
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setFont(new Font("System", Font.BOLD, 16));
        back.setBounds(360, 470, 150, 30);
        back.addActionListener(this);

        image.add(back);

        setSize(900, 850);
        setLocation(300, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transaction(username, cardnumber, pinnumber).setVisible(true);
        }
        if (ae.getSource() == withdraw) {
            try {

                Conn conn = new Conn();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

                String date = LocalDateTime.now().format(dtf);
                String amount = amountText.getText();
                //   String b="select balance from bank where cardnumber=='5690192012749109'";
                s = conn.c.createStatement();
                
                ResultSet rs = s.executeQuery("select * from bank where cardnumber='" + cardnumber + "'");

                if (rs.next()) {
                    balance = Integer.parseInt(rs.getString("balance"));
                }
                if (ae.getSource() != back && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Transaction Failed || Insufficient Balance");
                    setVisible(false);
                    new Transaction(username, cardnumber, pinnumber).setVisible(true);
                    

                } else {
                    balance = balance - Integer.parseInt(amount);

                    String mode = "Withdraw";
                    String query2 = "update bank set balance='" + balance + "' where cardnumber='" + cardnumber + "'";
                    String query1 = "Insert into transaction values(?,?,?,?,?,?)";
                    PreparedStatement ps2=conn.c.prepareStatement(query1);
                    Random r = new Random();
                    long tId = Math.abs(r.nextLong());
                    ps2.setString(1, cardnumber);
                    ps2.setLong(2, tId);
                    ps2.setString(3, mode);
                    ps2.setInt(6, balance);
                    ps2.setInt(5, Integer.parseInt(amount));
                    ps2.setString(4, date);

                    s.executeUpdate(query2);
                    ps2.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Amount Withdraw Succefffully");
                    setVisible(false);
                    new Transaction(username, cardnumber, pinnumber).setVisible(true);
                     

                }

            } 
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String args[]) {
        new Withdraw("", "", 0L);

    }
}
