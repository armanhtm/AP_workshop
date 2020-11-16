import javax.swing.*;
import java.awt.*;
/**
 * @author Arman Hatami
 * @version 1.0
 * calculator with no functionality ,it has 3 mood you can switch among
 */
public class Calculator {
    JFrame calcFrame;
    public Calculator() {
        init();
    }
    public JPanel Simple(){
        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setSize(200,200);
        keyboardPanel.setLocation(10, 150);
        keyboardPanel.setLayout(new GridLayout(5,3));
        calcFrame.add(keyboardPanel);
        for (int i = 9; i > 0; i--) {
            JButton btn = new JButton();
            btn.setText("" + i);
            keyboardPanel.add(btn);
        }
        JButton sumBtn = new JButton();
        sumBtn.setText("+");
        JButton subBtn = new JButton();
        subBtn.setText("-");
        keyboardPanel.add(sumBtn);
        keyboardPanel.add(subBtn);
        JButton zeroBtn = new JButton();
        zeroBtn.setText("0");
        keyboardPanel.add(zeroBtn);
        JButton doBtn = new JButton();
        doBtn.setText("=");
        keyboardPanel.add(doBtn);
        JButton divide = new JButton();
        divide.setText("/");
        keyboardPanel.add(divide);
        JButton mod = new JButton();
        mod.setText("%");
        keyboardPanel.add(mod);
        return keyboardPanel;
    }
    public JPanel ScientificFirst(){
        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setSize(200,200);
        keyboardPanel.setLocation(10, 150);
        keyboardPanel.setLayout(new GridLayout(5,3));
        calcFrame.add(keyboardPanel);
        for (int i = 9; i > 0; i--) {
            JButton btn = new JButton();
            btn.setText("" + i);
            keyboardPanel.add(btn);
        }
        JButton tan = new JButton();
        tan.setText("tan");
        keyboardPanel.add(tan);
        JButton sin = new JButton();
        sin.setText("sin");
        keyboardPanel.add(sin);
        JButton log = new JButton();
        log.setText("log");
        keyboardPanel.add(log);
        JButton sumBtn = new JButton();
        sumBtn.setText("+");
        JButton subBtn = new JButton();
        subBtn.setText("-");
        keyboardPanel.add(sumBtn);
        keyboardPanel.add(subBtn);
        JButton zeroBtn = new JButton();
        zeroBtn.setText("0");
        keyboardPanel.add(zeroBtn);
        JButton doBtn = new JButton();
        doBtn.setText("=");
        keyboardPanel.add(doBtn);
        return keyboardPanel;
    }
    public JPanel ScientificSecond(){
        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setSize(200,200);
        keyboardPanel.setLocation(10, 150);
        keyboardPanel.setLayout(new GridLayout(5,3));
        calcFrame.add(keyboardPanel);
        for (int i = 9; i > 0; i--) {
            JButton btn = new JButton();
            btn.setText("" + i);
            keyboardPanel.add(btn);
        }
        JButton cot = new JButton();
        cot.setText("cot");
        keyboardPanel.add(cot);
        JButton cos = new JButton();
        cos.setText("cos");
        keyboardPanel.add(cos);
        JButton exp = new JButton();
        exp.setText("exp");
        keyboardPanel.add(exp);
        JButton sumBtn = new JButton();
        sumBtn.setText("+");
        JButton subBtn = new JButton();
        subBtn.setText("-");
        keyboardPanel.add(sumBtn);
        keyboardPanel.add(subBtn);
        JButton zeroBtn = new JButton();
        zeroBtn.setText("0");
        keyboardPanel.add(zeroBtn);
        JButton doBtn = new JButton();
        doBtn.setText("=");
        keyboardPanel.add(doBtn);
        return keyboardPanel;
    }
    public void setScreen(){
        JTextArea display = new JTextArea(3,14);
        display.setEditable(false);
        display.setFont(new Font("Arial", 14,14));
        display.append("Start");
        display.setVisible(true);
        calcFrame.add(display);
        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setPreferredSize(new Dimension(170, 60));
        scrollPane.setLocation(20,40);
        calcFrame.add(scrollPane);
    }
    public void init(){
        calcFrame = new JFrame();
        calcFrame.setTitle("Calculator");
        calcFrame.setSize(300, 300);
        calcFrame.setLocation(20, 40);
        calcFrame.setLayout(new FlowLayout());
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setScreen();
        tab();
        calcFrame.setVisible(true);
    }
    public void tab(){
        JPanel mainMood = Simple();
        JPanel firstMood = ScientificFirst();
        JPanel secondMood = ScientificSecond();
        JTabbedPane tp=new JTabbedPane();
        tp.setBounds(50,50,200,200);
        tp.add("simple",mainMood);
        tp.add("firstType",firstMood);
        tp.add("secondType",secondMood);
        calcFrame.add(tp);
        calcFrame.setVisible(true);
    }
}
