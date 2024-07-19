package sunderdeep;

import com.mysql.cj.TransactionEventHandler;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class fastcash extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, exit;
    Long pinnumber;
    String cardnumber, username;
    ButtonGroup bg;
    int amount ;
    Statement s;
    int balance;

    fastcash(String username, String cardnumber, Long pinnumber) {
        this.username = username;

        this.cardnumber = cardnumber;
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 850);
        add(image);
        JLabel t = new JLabel("Please Select Your Amount:");
        t.setBounds(210, 280, 300, 30);
        t.setFont(new Font("System", Font.BOLD, 16));
        t.setForeground(Color.WHITE);
        image.add(t);

        //  JLabel =new JLabel();
        b1 = new JButton("100");
        b1.setFont(new Font("System", Font.BOLD, 14));
        b1.setBounds(150, 380, 150, 25);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("500");
        b2.setFont(new Font("System", Font.BOLD, 14));
        b2.setBounds(355, 380, 150, 25);
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("1000");
        b3.setFont(new Font("System", Font.BOLD, 14));
        b3.setBounds(150, 410, 150, 25);
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("2000");
        b4.setFont(new Font("System", Font.BOLD, 14));
        b4.setBounds(355, 410, 150, 25);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("5000");
        b5.setFont(new Font("System", Font.BOLD, 14));
        b5.setBounds(150, 440, 150, 25);
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("10000");
        b6.setFont(new Font("System", Font.BOLD, 14));
        b6.setBounds(355, 440, 150, 25);
        b6.addActionListener(this);
        image.add(b6);

        exit = new JButton("Exit");
        exit.setFont(new Font("System", Font.BOLD, 14));
        exit.setBounds(355, 470, 150, 25);
        exit.addActionListener(this);

        image.add(exit);

        setSize(900, 850);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
        } else {
            String cashAmount=((JButton)ae.getSource()).getText();
            amount=Integer.parseInt(cashAmount);
           
            try {
                Conn conn = new Conn();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                String date = LocalDateTime.now().format(dtf);
                s = conn.c.createStatement();
                ResultSet rs = s.executeQuery("select * from bank where cardnumber='" + cardnumber + "'");
                if(rs.next()) {
                    balance = Integer.parseInt(rs.getString("balance"));
                }
                if (balance < amount) {
                    JOptionPane.showMessageDialog(null, "Transaction Failed || Insufficient Balance");
                    setVisible(false);
                    new Transcation(username, cardnumber, pinnumber).setVisible(true);

                } else {
                    balance = balance - amount;

                    String mode = "Fast Withdraw";
                    String query2 = "update bank set balance='" + balance + "' where cardnumber='" + cardnumber + "'";

                    String query1 = "Insert into transaction values(?,?,?,?,?,?)";
                    PreparedStatement ps2 = conn.c.prepareStatement(query1);
                    Random r = new Random();
                    long tId = Math.abs(r.nextLong());
                    ps2.setString(1, cardnumber);
                    ps2.setLong(2, tId);
                    ps2.setString(3, mode);
                    ps2.setInt(6, balance);
                    ps2.setInt(5, amount);
                    ps2.setString(4, date);

                    s.executeUpdate(query2);
                    ps2.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Amount Withdraw Succefffully");
                    setVisible(false);
                    new Transcation(username, cardnumber, pinnumber).setVisible(true);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String args[]) {
        new fastcash("", "", 0L);
    }

}
