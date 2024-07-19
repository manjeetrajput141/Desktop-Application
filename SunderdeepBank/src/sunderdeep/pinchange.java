package sunderdeep;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class pinchange extends JFrame implements ActionListener {

    Statement s;
    int p,rp;
    Long pinnumber;
    String cardnumber, username;
    JButton change, back;
    JPasswordField pin,repin;

    pinchange(String username, String cardnumber, Long pinnumber) {
        this.username = username;
        this.cardnumber = cardnumber;
        this.pinnumber = pinnumber;
        setSize(900, 900);
        getContentPane().setBackground(Color.WHITE);
        setLocation(300, 0);

        this.cardnumber = cardnumber;
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel t = new JLabel("Enter Your New Pin");
        t.setBounds(210, 250, 300, 30);
        t.setFont(new Font("System", Font.BOLD, 16));
        t.setForeground(Color.WHITE);
        image.add(t);
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(200, 300, 250, 30);
        image.add(pin);
        
        JLabel t2 = new JLabel("Re-Enter Your New Pin");
        t2.setBounds(210, 350, 300, 30);
        t2.setFont(new Font("System", Font.BOLD, 16));
        t2.setForeground(Color.WHITE);
        image.add(t2);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 22));
        repin.setBounds(200, 400, 250, 30);
        image.add(repin);

        change = new JButton("Change");
        change.setFont(new Font("System", Font.BOLD, 16));
        change.setBounds(360, 460, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setFont(new Font("System", Font.BOLD, 16));
        back.setBounds(360, 495, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transcation(username, cardnumber, pinnumber).setVisible(true);
        } else if (ae.getSource() == change) {
            this.p = Integer.parseInt(pin.getText());
            this.rp=Integer.parseInt(repin.getText());
            System.out.println("Pin :"+p+"    Repin : "+rp);
            if(p==rp)
            {
                Conn conn=new Conn();
  
            try {
                String query1 = "Insert into transaction values(?,?,?,?,?,?)";
                String mode="Pin Change";
                 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                 System.out.println("Working 1");
                String date = LocalDateTime.now().format(dtf);
                PreparedStatement ps2 = conn.c.prepareStatement(query1);
                Random r = new Random();
                long tId = Math.abs(r.nextLong());
                ps2.setString(1, cardnumber);
                ps2.setLong(2, tId);
                ps2.setString(3, mode);
                ps2.setString(4, date);
                 ps2.setInt(5, 0);
                ps2.setInt(6, 0);
               ps2.executeUpdate();
                
               String query2="update bank set pinnumber=? where cardnumber=?";
                System.out.println("Working 2");
                
                PreparedStatement ps3=conn.c.prepareStatement(query2);
                ps3.setInt(1, p);
                ps3.setString(2, cardnumber);
                System.out.println("Working 3");
                ps3.executeUpdate();   
                System.out.println("Working 4");
                String query3="update login set pinnumber=? where cardnumber=?";
                PreparedStatement ps4=conn.c.prepareStatement(query3);
                ps4.setInt(1, p);
                ps4.setString(2, cardnumber);
                System.out.println("Working 5");
                ps4.executeUpdate();
                System.out.println("Working 6");
                String query4="update signupthree set pinnumber=? where cardnumber=?";
                PreparedStatement ps5=conn.c.prepareStatement(query4);
                System.out.println("Working 7");
                ps5.setInt(1,p);
                ps5.setString(2, cardnumber);
                System.out.println("Working 7");
                ps5.executeUpdate();
                
                

                JOptionPane.showMessageDialog(null, "Pin Changed Succefully");

            } catch (Exception e) {
                System.out.print(e);
            }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Re-enter the same PIN");
            }
        }

    }

    public static void main(String[] args) {
        new pinchange("", "", 0L);

    }

}
