package sunderdeep;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame {

    String cardnumber, username;
    Long pin;

    public MiniStatement(String name, String cardnumber, Long pin) {
        this.cardnumber = cardnumber;
        this.pin = pin;
        this.username = username;
        setLayout(null);

        JLabel heading1 = new JLabel("Sunderdeep Bank ");
        heading1.setBounds(120, 10, 300, 30);
        heading1.setFont(new Font("Raleway", Font.BOLD, 26));
        add(heading1);

        JLabel card = new JLabel("Card Number :");
        card.setBounds(30, 70, 200, 20);
        card.setFont(new Font("Raleway", Font.BOLD, 18));
        add(card);
        JLabel cardNumber = new JLabel(this.cardnumber.substring(0, 4) + "XXXXXXXX" + this.cardnumber.substring(12));
        cardNumber.setBounds(160, 70, 200, 20);
        cardNumber.setFont(new Font("Raleway", Font.PLAIN, 18));
        add(cardNumber);
        try {
            Conn conn = new Conn();
            String query = "select * from transaction where cardnumber=? ORDER BY transaction_date DESC";
            PreparedStatement pstmt = conn.c.prepareStatement(query);
            pstmt.setString(1, this.cardnumber);

            ResultSet rs = pstmt.executeQuery();
            int x=30,y=100,w=400,h=15;
            while (rs.next()) {
                
                Long tid=rs.getLong("transaction_id");
                String t_type=rs.getString("transaction_type");
                String t_date=rs.getString("transaction_date");
                int t_amount=rs.getInt("transaction_amount");
                String t_balance=""+(rs.getInt("balance"));
                if(t_type.equals("Pin Change"))
                {
                    t_balance="XXXX";
                }
                
                JLabel t1 = new JLabel("Transaction Id :"+tid);
                t1.setBounds(x, y, w, h);
                t1.setFont(new Font("Raleway", Font.BOLD, 12));
                add(t1);
                y=y+20;
                JLabel t2 = new JLabel("Transaction Date :"+t_date);
                t2.setBounds(x, y, w, h);
                t2.setFont(new Font("Raleway", Font.BOLD, 12));
                add(t2);
                y=y+20;
                JLabel t3 = new JLabel("Transaction Type :"+t_type);
                t3.setBounds(x, y, w, h);
                t3.setFont(new Font("Raleway", Font.BOLD, 12));
                add(t3);
                y=y+20;
                JLabel t4 = new JLabel("Transaction Amount :"+t_amount);
                t4.setBounds(x, y, w, h);
                t4.setFont(new Font("Raleway", Font.BOLD, 12));
                add(t4);
                y=y+20;
                JLabel t5 = new JLabel("Total Balance :"+t_balance);
                t5.setBounds(x, y, w, h);
                t5.setFont(new Font("Raleway", Font.BOLD, 12));
                add(t5);
                y=y+20;
                
                 JLabel seperator = new JLabel("-----------------------------------------------");
                seperator.setBounds(x, y, 600, 20);
                seperator.setFont(new Font("Raleway", Font.BOLD, 12));
                add(seperator);
                y=y+20;
                if(y>=580)
                {
                    y=100;
                    x=x+300;
                    
                }
                
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setSize(600, 600);
        setBounds(10, 10, 600, 600);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MiniStatement("", "", 0L);

    }

}
