package DigitalClock;

import java.awt.*;
import static java.lang.Thread.sleep;
import javax.swing.*;
import java.util.*;

public class DigitalClock extends JFrame {

    JLabel lclock = new JLabel();

    public DigitalClock() {
        lclock.setHorizontalAlignment(JLabel.CENTER);
        lclock.setOpaque(true);
        lclock.setFont(new Font("Digital-7", Font.BOLD, 40));
        lclock.setBackground(Color.black);
        lclock.setForeground(Color.green);

        setTitle("Digital Clock");
        setSize(250, 100);
        add(lclock);
        setLocationRelativeTo(null);
        setVisible(true);

        new MyThread().start();
        setIconImage();
    };

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("digital-clock.png")));
    };

    class MyThread extends Thread {

        public void run() {
            while (true) {
                Date d = new Date();
                String hr = (d.getHours() % 12) < 10 ? "0" + (d.getHours() % 12) : "" + (d.getHours() % 12);
                String min = d.getMinutes() < 10 ? "0" + d.getMinutes() : "" + d.getMinutes();
                String sec = d.getSeconds() < 10 ? "0" + d.getSeconds() : "" + d.getSeconds();

                String t = hr + " : " + min + " : " + sec;
                lclock.setText(t);
                try {
                    sleep(100);
                } catch (Exception ex) {
                    break;
                };
            };
        };
    };

    public static void main(String[] args) {
        new DigitalClock();
    };
};
