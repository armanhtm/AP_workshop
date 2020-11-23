import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * @author Arman Hatami
 * @version 1.0
 * calculator with no functionality ,it has 3 mood you can switch among
 */
public class Calculator implements ActionListener {
    JFrame calcFrame;
    JTextArea display;
    String s0, s1, s2,temp;
    public Calculator() {
        init();
        s0 = s1 = s2 = "";
    }
    public JPanel Simple(){
        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setSize(200,200);
        keyboardPanel.setLocation(10, 150);
        keyboardPanel.setLayout(new GridLayout(4,4));
        calcFrame.add(keyboardPanel);
        for (int i = 9; i > 0; i--) {
            JButton btn = new JButton();
            btn.setText("" + i);
            keyboardPanel.add(btn);
            btn.addActionListener(this);
        }
        JButton zeroBtn = new JButton();
        zeroBtn.setText("0");
        keyboardPanel.add(zeroBtn);
        zeroBtn.addActionListener(this);
        JButton sumBtn = new JButton();
        sumBtn.setText("+");
        sumBtn.setToolTipText("addition");
        keyboardPanel.add(sumBtn);
        sumBtn.addActionListener(this);
        JButton subBtn = new JButton();
        subBtn.setText("-");
        subBtn.setToolTipText("subtraction");
        keyboardPanel.add(subBtn);
        subBtn.addActionListener(this);
        JButton doBtn = new JButton();
        doBtn.setText("=");
        doBtn.setToolTipText("equal");
        keyboardPanel.add(doBtn);
        doBtn.addActionListener(this);
        JButton divide = new JButton();
        divide.setText("/");
        divide.setToolTipText("division");
        keyboardPanel.add(divide);
        divide.addActionListener(this);
        JButton multiple = new JButton();
        multiple.setText("x");
        multiple.setToolTipText("multiplication");
        keyboardPanel.add(multiple);
        multiple.addActionListener(this);
        JButton clear = new JButton();
        clear.setText("C");
        clear.setToolTipText("clear");
        keyboardPanel.add(clear);
        clear.addActionListener(this);
        return keyboardPanel;
    }
    public void setScreen(){
        display.setEditable(false);
        display.setFont(new Font("Arial", 14,14));
        display.append("Start");
        display.setToolTipText("main screen");
        display.setVisible(true);
        calcFrame.add(display);
        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setPreferredSize(new Dimension(170, 60));
        scrollPane.setLocation(20,40);
        calcFrame.add(scrollPane);
    }
    public void init(){
        calcFrame = new JFrame();
        display = new JTextArea(3,14);
        calcFrame.setTitle("Calculator");
        calcFrame.setSize(300, 300);
        calcFrame.setLocation(20, 40);
        calcFrame.setLayout(new FlowLayout());
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setScreen();
        calcFrame.add(Simple());
        addMenu();
        calcFrame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if(s.charAt(0) == 'C'){
            StringSelection stringSelection = new StringSelection(temp);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            temp = "";
        }
        if(s.charAt(0) == 'E')
            System.exit(0);
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {

            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;

            display.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'C') {
            s0 = s1 = s2 = "";
            display.setText(s0 + s1 + s2);
            temp = "";
        }
        else if (s.charAt(0) == '=') {

            double te;

            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));

            display.setText(s0 + s1 + s2 + "=" + te);
            temp = s0 + s1 + s2 + "=" + te;
            s0 = Double.toString(te);
            s1 = s2 = "";
        }
        else {
            if (s1.equals("") || s2.equals(""))
                s1 = s;
            else {
                double te;

                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));

                s0 = Double.toString(te);
                s1 = s;
                s2 = "";
            }
            display.setText(s0 + s1 + s2);
            temp = s0 + s1 + s2;
        }
    }
    public void addMenu(){
        JMenuBar menuBar = new JMenuBar();
        JMenu optionMenu = new JMenu("options");
        menuBar.add(optionMenu);
        JMenuItem copyText = new JMenuItem("Copy screen", 'C');
        copyText.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
        copyText.addActionListener(this);
        optionMenu.add(copyText);
        JMenuItem exitItem = new JMenuItem("Exit", 'E');
        exitItem.addActionListener(this);
        optionMenu.add(exitItem);
        calcFrame.setJMenuBar(menuBar);
    }
}
