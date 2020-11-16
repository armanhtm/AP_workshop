import javax.swing.*;
/**
 * @author Arman Hatami
 * @version 1.0
 * main for test our calculator
 */
public class Main {

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("error");
        }
        Calculator calculator = new Calculator();
    }
}
