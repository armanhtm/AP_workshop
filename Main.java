/**
 * @author Arman Hatami
 * Coursera User ID:  123456
 * Last modified:     1/1/2019
 * ***************************************************************************
 */

package clock;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        JButton b = new JButton();
        b.setBounds(100, 100, 100, 50);
        f.add(b);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
        ClockDisplay clock = new ClockDisplay();
        clock.setTime(0, 0, 0);
        while (true) {
            try {
                b.setText(clock.getTime());
                clock.timeTick();
                Thread.sleep(1000);
            }
            catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
