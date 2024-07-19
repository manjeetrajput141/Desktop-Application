package sunderdeep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    PreparedStatement s1, s2;
    JRadioButton b1, b2, b3, b4;
    JButton cancel, next;
    JLabel type, card, number, services, pin, pinnumber, pindetail, carddetail;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    Long Formno;

    SignupThree(Long Formno) {

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/back.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        setTitle("Account Details");
        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 24));
        l1.setBounds(250, 40, 300, 30);
        image.add(l1);

        type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        type.setBounds(100, 100, 200, 30);
        image.add(type);

        b1 = new JRadioButton("Saving Account");
        b1.setFont(new Font("Raleway", Font.BOLD, 16));
        b1.setOpaque(false);

        b1.setBounds(100, 150, 200, 20);
        b2 = new JRadioButton("Current Account");
        b2.setOpaque(false);
        b2.setFont(new Font("Raleway", Font.BOLD, 16));
        b2.setBounds(100, 180, 200, 20);
        b3 = new JRadioButton("Fixed Deposit Account");
        b3.setFont(new Font("Raleway", Font.BOLD, 16));
        b3.setOpaque(false);
        b3.setBounds(330, 150, 200, 20);
        b4 = new JRadioButton("Recurring Account");
        b4.setFont(new Font("Raleway", Font.BOLD, 16));
        b4.setBounds(330, 180, 200, 20);
        b4.setOpaque(false);

        image.add(b1);
        image.add(b2);
        image.add(b3);
        image.add(b4);
        ButtonGroup group = new ButtonGroup();
        group.add(b1);
        group.add(b2);
        group.add(b3);
        group.add(b4);

        card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(100, 240, 200, 30);
        image.add(card);

        number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 20));
        number.setBounds(300, 240, 300, 30);
        image.add(number);
        carddetail = new JLabel("Your 16 digit Card Number");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetail.setBounds(100, 280, 300, 20);
        image.add(carddetail);
        pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 320, 300, 30);
        image.add(pin);
        pindetail = new JLabel("Your 4 Digit PIN Number");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetail.setBounds(100, 340, 300, 20);
        image.add(pindetail);

        pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 20));
        pinnumber.setBounds(300, 320, 300, 30);
        image.add(pinnumber);

        services = new JLabel("Services Required");
        services.setFont(new Font("Raleway", Font.BOLD, 20));
        services.setBounds(100, 380, 300, 20);
        image.add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 420, 200, 20);
        c1.setOpaque(false);
        image.add(c1);
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 12));
        c2.setBounds(100, 460, 200, 20);
        c2.setOpaque(false);
        image.add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setOpaque(false);
        c3.setBounds(100, 500, 200, 20);
        image.add(c3);
        c4 = new JCheckBox("E-Mails Alerts");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setOpaque(false);
        c4.setBounds(300, 420, 200, 20);
        image.add(c4);
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setOpaque(false);
        c5.setBounds(300, 460, 200, 20);
        image.add(c5);
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setOpaque(false);
        c6.setBounds(300, 500, 200, 20);
        image.add(c6);

        c7 = new JCheckBox("I Hereby declare that the above entered details are correct");
        c7.setFont(new Font("Raleway", Font.BOLD, 16));
        c7.setOpaque(false);
        c7.setBounds(100, 580, 800, 20);
        image.add(c7);

        next = new JButton("Next");
        cancel = new JButton("Cancel");
        next.setFont(new Font("Raleway", Font.BOLD, 16));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(300, 640, 100, 30);
        next.addActionListener(this);
        image.add(next);
        cancel.setFont(new Font("Raleway", Font.BOLD, 16));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(480, 640, 100, 30);
        cancel.addActionListener(this);
        image.add(cancel);

        this.Formno = Formno;
        getContentPane().setBackground(Color.WHITE);
        setSize(750, 800);
        setLocation(300, 40);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            boolean checkbox = c7.isSelected();
            String accountType = null;
            if (b1.isSelected()) {
                accountType = "Saving Account";
            }
            if (b2.isSelected()) {
                accountType = "Current Account";
            }
            if (b3.isSelected()) {
                accountType = "Fixed deposit Account";
            }
            if (b4.isSelected()) {
                accountType = "Reccuring Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 9000000L) + 5690192020000000L);
            Long pinnumber =  Math.abs((random.nextLong() % 9000L)) + 1000L;
            
            String facility = "";
            if (c1.isSelected()) {
                facility = facility + " ATM_Card";
            }
            if (c2.isSelected()) {
                facility = facility + " Internet_Banking";

            }
            if (c3.isSelected()) {
                facility = facility + " Mobile_Banking";

            }
            if (c4.isSelected()) {
                facility = facility + " Email_SMS_Alerts";

            }
            if (c5.isSelected()) {
                facility = facility + " Cheque_Book";

            }
            if (c6.isSelected()) {
                facility = facility + " E-Statement";

            }
            if (ae.getSource() == next) {

                if (checkbox) {

                    try {
                        Conn conn = new Conn();
                        String query1 = "insert into signupthree values('" + Formno + "','" + accountType + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
                        String query2 = "insert into login values('" + Formno + "','" + cardnumber + "','" + pinnumber + "')";

                        s1 = conn.c.prepareStatement(query1);
                        s2 = conn.c.prepareStatement(query2);

                        s1.executeUpdate();
                        s2.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Card Number :" + cardnumber + "\nPin :" + pinnumber);

                        setVisible(false);
                        new signupfour(cardnumber, pinnumber,accountType).setVisible(true);

                    } catch (Exception e) {
                        System.out.print(e);

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pleack Check the Declaration before submit");
                }

            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);

        }

    }

    public static void main(String args[]) {
        new SignupThree(5L);
    }

}
