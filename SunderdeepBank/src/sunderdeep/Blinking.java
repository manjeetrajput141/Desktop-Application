package sunderdeep;

import java.awt.*;
import javax.swing.*;

public class Blinking extends JFrame implements Runnable{

    Thread thread;
    Blinking() {
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sdgi.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 500);
        add(image);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        thread=new Thread(this);
        thread.start();

    }
    @Override
    public void run()
    {
        try
        {
            Thread.sleep(7000);
            new Login().setVisible(true);
            setVisible(false);
        }catch(Exception e){
        }
        
    }

    public static void main(String[] args) {
        Blinking blinking = new Blinking();
        int i;
        int k = 1;

        for (i = 1; i < 400; i++) {
            blinking.setLocation(600 - i, 400 - i / 2);
            blinking.setSize(i * 2, i * (3/2));
//            if (i == 298 && k < 2) {
//                i = 0;
//                k = k + 1;
//
//            }

            try {
                Thread.sleep(3);

            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }

}
