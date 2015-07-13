package eu.salingers.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import eu.salingers.FileFinder;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class ConfigurationTool
    implements ActionListener {
  private static final String CHOOSE_DIRECTORY = "Please Choose Directory...";

  private static final String CANCEL = "Cancel";

  private static final String WILDCARD = "*";

  private static final String SOURCE_FILE_SUFFIX_PATTERN = ".properties.sample";

  JButton go;

  JFileChooser chooser;

  String choosertitle;

  private JLabel lblDirectory;

  private JButton btnCancel;

  private JList<Object> lstFileList = new JList<>();

  private JScrollPane listPane = new JScrollPane();

  private JFrame frame = new JFrame();

  private JPanel panel = new JPanel();

  public ConfigurationTool() {
    addComponentsToPanel();
    addPanelToFrame();
  }

  private void addPanelToFrame() {
    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EDIT
//    frame.pack();
    frame.getContentPane().add(panel,"Center");
    frame.setSize(panel.getPreferredSize());
    frame.setVisible(true);
  }

  private void addComponentsToPanel() {
    panel.setSize(getPreferredSize());

    go = new JButton(CHOOSE_DIRECTORY);
    go.setBounds(5, 5, 208, 29);
    go.addActionListener(this);
    panel.setLayout(null);
    panel.add(go);

    lblDirectory = new JLabel("Directory");
    lblDirectory.setBounds(218, 11, 58, 16);
    lblDirectory.setVisible(true);
    panel.add(lblDirectory);

    btnCancel = new JButton(CANCEL);
    btnCancel.setBounds(281, 5, 86, 29);
    btnCancel.addActionListener(this);
    btnCancel.setEnabled(false);
    panel.add(btnCancel);

    JLabel lblNewLabel = new JLabel("Copy all *.properties.sample files to *.properties files");
    lblNewLabel.setBounds(372, 9, 429, 20);
    lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
    panel.add(lblNewLabel);



  }

  public void actionPerformed(ActionEvent e) {
    System.out.println("Event    " + e.getActionCommand());

    switch (e.getActionCommand()) {
    case CHOOSE_DIRECTORY:
      System.out.println("Entering case CHOOSE_DIRECTORY");
      String sourceFilePattern = WILDCARD + SOURCE_FILE_SUFFIX_PATTERN;
      File file = chooseDirectory();

      try {
        FileFinder finder = findFiles(Paths.get(file.getAbsolutePath()), sourceFilePattern);
        Object[] fileArray = finder.getMatches().toArray();
        lstFileList = new JList<Object>(fileArray);

        lstFileList.setBounds(5, 90, 700, 100);
        lstFileList.setVisibleRowCount(5);
        listPane.setViewportView(lstFileList);

        panel.add(lstFileList);

        lstFileList.repaint();
      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
      break;

    case CANCEL:
      System.out.println("Entering case CANCEL");
      cancel();
      panel.remove(lstFileList);
      panel.repaint();
      break;

    default:
      break;
    }
  }

  private void cancel() {
    lblDirectory.setVisible(false);
    go.setEnabled(true);
    btnCancel.setEnabled(false);

  }

  private File chooseDirectory() {
    chooser = new JFileChooser();
    chooser.setCurrentDirectory(new java.io.File("/Users/orestis/Documents/workspace_legic/PROJECTS/superproject/"));
    chooser.setDialogTitle(choosertitle);
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setFileHidingEnabled(true);
    // disable the "All files" option.
    //
    chooser.setAcceptAllFileFilterUsed(false);
    //
    if (chooser.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION) {

      lblDirectory.setVisible(true);
      go.setEnabled(false);
      btnCancel.setVisible(true);
      btnCancel.setEnabled(true);

      lblDirectory.setText(chooser.getSelectedFile().toString());
      System.out.println("getSelectedFile() : "
          + chooser.getSelectedFile());
      return chooser.getSelectedFile();

    }
    else {
      System.out.println("No Selection ");
      return new File("");
    }
  }

  private FileFinder findFiles(Path startingDir, String pattern) throws IOException {
    return new FileFinder(startingDir, pattern);

  }

  public Dimension getPreferredSize() {
    return new Dimension(1000, 500);
  }

  public static void main(String s[]) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new ConfigurationTool();
      }
    });
  }

  // frmFrame = new JFrame("");
  // ConfigurationTool panel = new ConfigurationTool();
  // frmFrame.addWindowListener(
  // new WindowAdapter() {
  // public void windowClosing(WindowEvent e) {
  // System.exit(0);
  // }
  // }
  // );
  // frmFrame.getContentPane().add(panel,"Center");
  // frmFrame.setSize(panel.getPreferredSize());
  // frmFrame.setVisible(true);
  // }
}