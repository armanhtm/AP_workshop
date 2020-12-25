package ceit.aut.ac.ir.gui;
import ceit.aut.ac.ir.model.Note;
import ceit.aut.ac.ir.utils.FileUtils;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
/**
 * @author Arman Hatami
 * @version 1.0
 * to create the main panel for writing
 */
public class CMainPanel extends JPanel {

    private JTabbedPane tabbedPane;
    private JList<File> directoryList;

    /**
     * constructor method
     */
    public CMainPanel() {

        setLayout(new BorderLayout());

        initDirectoryList(); // add JList to main Panel

        initTabbedPane(); // add TabbedPane to main panel

        addNewTab(); // open new empty tab when user open the application
    }

    /**
     * initialize Jtab
     */
    private void initTabbedPane() {
        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);
    }

    /**
     * initialize directory list
     */
    private void initDirectoryList() {
        File[] files = FileUtils.getFilesInDirectory();
        directoryList = new JList<>(files);

        directoryList.setBackground(new Color(211, 211, 211));
        directoryList.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        directoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        directoryList.setVisibleRowCount(-1);
        directoryList.setMinimumSize(new Dimension(130, 100));
        directoryList.setMaximumSize(new Dimension(130, 100));
        directoryList.setFixedCellWidth(130);
        directoryList.setCellRenderer(new MyCellRenderer());
        directoryList.addMouseListener(new MyMouseAdapter());

        add(new JScrollPane(directoryList), BorderLayout.WEST);
    }


    /**
     * add a new tab
     */
    public void addNewTab() {
        JTextArea textPanel = createTextPanel();
        tabbedPane.addTab("Tab " + (tabbedPane.getTabCount() + 1), textPanel);
    }

    /**
     * open an existed note
     * @param content
     */
    public void openExistingNote(String content) {
        JTextArea existPanel = createTextPanel();
        existPanel.setText(content);

        int tabIndex = tabbedPane.getTabCount() + 1;
        tabbedPane.addTab("Tab " + tabIndex, existPanel);
        tabbedPane.setSelectedIndex(tabIndex - 1);
    }

    /**
     * save a note
     */
    public void saveNote() {
        JTextArea textPanel = (JTextArea) tabbedPane.getSelectedComponent();
        String note = textPanel.getText();



        if (!note.isEmpty()) {
            try {
                FileUtils.fileWriter(note);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





//        if (!note.isEmpty()) {
//            FileUtils.fileWriterBuffer(note);
//        }






//        if (!note.isEmpty()) {
//            FileUtils.filewWriterSerialize(note);
//        }

        updateListGUI();
    }

    /**
     * create Jtextpanel
     * @return
     */
    private JTextArea createTextPanel() {
        JTextArea textPanel = new JTextArea();
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return textPanel;
    }

    private void updateListGUI() {
        File[] newFiles = FileUtils.getFilesInDirectory();
        directoryList.setListData(newFiles);
    }


    /**
     * class for mouse actions
     */
    private class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent eve) {
            // Double-click detected
            if (eve.getClickCount() == 2) {
                int index = directoryList.locationToIndex(eve.getPoint());
                System.out.println("Item " + index + " is clicked...");
                //TODO: Phase1: Click on file is handled... Just load content into JTextArea



                File curr[] = FileUtils.getFilesInDirectory();
                String content = null;
                try {
                    content = FileUtils.fileReader(curr[index]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                openExistingNote(content);


//                File curr[] = FileUtils.getFilesInDirectory();
//                String content = null;
//                content = FileUtils.fileReaderBuffer(curr[index]);
//                openExistingNote(content);


//                File curr[] = FileUtils.getFilesInDirectory();
//                Note content = null;
//                content = FileUtils.fileReaderSerialize(curr[index]);
//                openExistingNote(content.toString());
            }
        }
    }


    /**
     * class for rending
     */
    private class MyCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object object, int index, boolean isSelected, boolean cellHasFocus) {
            if (object instanceof File) {
                File file = (File) object;
                setText(file.getName());
                setIcon(FileSystemView.getFileSystemView().getSystemIcon(file));
                if (isSelected) {
                    setBackground(list.getSelectionBackground());
                    setForeground(list.getSelectionForeground());
                } else {
                    setBackground(list.getBackground());
                    setForeground(list.getForeground());
                }
                setEnabled(list.isEnabled());
            }
            return this;
        }
    }

    /**
     * get Jtab
     * @return JtabbedPane
     */
    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }
    public void saveTabPane() {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            tabbedPane.setSelectedIndex(i);
            JTextArea textPanel = (JTextArea) tabbedPane.getSelectedComponent();
            String note = textPanel.getText();


            if (!note.isEmpty()) {
                try {
                    FileUtils.fileWriter(note);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


//        if (!note.isEmpty()) {
//            FileUtils.fileWriterBuffer(note);
//        }


//        if (!note.isEmpty()) {
//            FileUtils.filewWriterSerialize(note);
//        }

        }
    }
}
