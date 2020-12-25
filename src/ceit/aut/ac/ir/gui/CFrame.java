package ceit.aut.ac.ir.gui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Arman Hatami
 * @version 1.0
 * create the main jframe
 */
public class CFrame extends JFrame implements ActionListener {

    private ceit.aut.ac.ir.gui.CMainPanel mainPanel;

    private JMenuItem newItem;
    private JMenuItem saveItem;
    private JMenuItem exitItem;

    /**
     *constructor method
     *@param title
     */
    public CFrame(String title) {
        super(title);

        initMenuBar(); //create menuBar

        initMainPanel(); //create main panel
    }

    /**
     * initialize menu bar
     */
    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu jmenu = new JMenu("File");

        newItem = new JMenuItem("New");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        newItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        jmenu.add(newItem);
        jmenu.add(saveItem);
        jmenu.add(exitItem);

        menuBar.add(jmenu);
        setJMenuBar(menuBar);
    }

    /**
     * initialize panel
     */
    private void initMainPanel() {
        mainPanel = new ceit.aut.ac.ir.gui.CMainPanel();
        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newItem) {
            mainPanel.addNewTab();
        } else if (e.getSource() == saveItem) {
            mainPanel.saveNote();
        } else if (e.getSource() == exitItem) {
            //TODO: Phase1: check all tabs saved ...
            for (int i=0;i<mainPanel.getTabbedPane().getTabCount();i++) {
                mainPanel.saveTabPane();
                System.out.println("tab"+i+"saved");
            }
            System.exit(0);
        } else {
            System.out.println("Nothing detected...");
        }
    }
}
