package ceit.aut.ac.ir;
import ceit.aut.ac.ir.gui.CFrame;
import javax.swing.*;
/**
 * @author Arman Hatami
 * @version 1.0
 * main class where i just run the program
 */
public class Main {

    public static void main(String[] args) {
        //change look and feel to Nimbus
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        CFrame frame = new CFrame("NoteBook");
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}

