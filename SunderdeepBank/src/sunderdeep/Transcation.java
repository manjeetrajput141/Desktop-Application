
package sunderdeep;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Transcation extends JFrame implements ActionListener{
   JButton deposit,withdraw,fastcash,balance,pinchange,mini,b7; 
   Long pinnumber;
   String cardnumber;
   String username;
    
    Transcation(String username,String cardnumber,Long pinnumber)
    {
        this.username=username;
       
        this.cardnumber=cardnumber;
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT );
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel u=new JLabel("   Welcome , "+username);
        u.setBounds(220,280,300,30);
        u.setFont(new Font("System",Font.BOLD,18));
        u.setForeground(Color.WHITE);
        image.add(u);
        JLabel t=new JLabel("Please Select Your Transcation:");
        t.setBounds(220,330,300,30);
        t.setFont(new Font("System",Font.BOLD,16));
        t.setForeground(Color.WHITE);
        image.add(t);
        
      //  JLabel =new JLabel();
        deposit=new JButton("Deposit");
        deposit.setFont(new Font("System",Font.BOLD,14));
        deposit.setBounds(165,400,150,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdraw=new JButton("Withdraw");
        withdraw.setFont(new Font("System",Font.BOLD,14));
        withdraw.setBounds(370,400,150,25);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setFont(new Font("System",Font.BOLD,14));
        fastcash.setBounds(165,430,150,25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        balance=new JButton("Balance Enquiry");
        balance.setFont(new Font("System",Font.BOLD,14));
        balance.setBounds(370,430,150,25);
        balance.addActionListener(this);
        image.add(balance);
        
        pinchange=new JButton("Pin Change");
        pinchange.setFont(new Font("System",Font.BOLD,14));
        pinchange.setBounds(165,460,150,25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        mini=new JButton("Mini Statement");
        mini.setFont(new Font("System",Font.BOLD,14));
        mini.setBounds(370,460,150,25);
        mini.addActionListener(this);
        image.add(mini);
        
        
        b7=new JButton("Exit");
        b7.setFont(new Font("System",Font.BOLD,14));
        b7.setBounds(370,490,150,25);
        b7.addActionListener(this);
        
        image.add(b7);
        
        
        setSize(900,850);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        Conn conn=new Conn();
        
        
                   
        
        
        if(ae.getSource()==b7)
        {
            System.exit(0);
        }
        if(ae.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(username,cardnumber,pinnumber).setVisible(true);
            
        }
        if(ae.getSource()==withdraw)
        {
            setVisible(false);
            new Withdraw(username,cardnumber,pinnumber).setVisible(true);
            
            
        }
        if(ae.getSource()==fastcash)
        {
           setVisible(false);
            new fastcash(username,cardnumber,pinnumber).setVisible(true);
            
        }
        if(ae.getSource()==balance)
        {
            setVisible(false);
            new balance(username,cardnumber,pinnumber).setVisible(true);
            
        }
        if(ae.getSource()==pinchange)
        {
            setVisible(false);
            new pinchange(username,cardnumber,pinnumber).setVisible(true);
            
        }
        if(ae.getSource()==mini)
        {
            
        }
        
    }
    
    public static void main(String args[])
    {
        new Transcation(""
                        ,"",0L);
    }
    
}
