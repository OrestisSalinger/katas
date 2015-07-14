package eu.salingers.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

public class ConfigurationTool implements ActionListener {
  private static final String COPY = "Copy!";

  private static final String CHOOSE_DIRECTORY = "Browse for directory...";

  private static final String CANCEL = "Cancel";

  private static final String WILDCARD = "*";

  private static final String SOURCE_FILE_SUFFIX_PATTERN = ".properties.sample";
  
  private static final String REMOVE_FROM_FILENAME = ".sample";

  JButton go;

  JFileChooser chooser;

  String choosertitle = "";

  private JLabel lblDirectory;

  private JButton btnCancel;

  private JButton btnCopy;

  private JList<Object> lstFileList = new JList<>();
  
  private JScrollPane listPane;

  private JFrame frame = new JFrame();

  private JPanel panel = new JPanel();

  private Object[] filesFound;

  private FileFinder finder;

  private JPanel listContainer;


  public ConfigurationTool() {
    addComponentsToPanel();
    addPanelToFrame();
  }

  private void addPanelToFrame() {
    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EDIT
    frame.getContentPane().add(panel, "Center");
    frame.setSize(panel.getPreferredSize());
    frame.setTitle("FILE TOOL");
    frame.setVisible(true);
  }

  private void addComponentsToPanel() {
    panel.setSize(getPreferredSize());

    go = new JButton(CHOOSE_DIRECTORY);
    go.setBounds(25, 35, 220, 30);
    go.addActionListener(this);
    panel.setLayout(null);
    panel.add(go);


    btnCopy = new JButton(COPY);
    btnCopy.setBounds(25, 80, 110, 30);
    btnCopy.addActionListener(this);
    btnCopy.setEnabled(false);
    panel.add(btnCopy);
    
    btnCancel = new JButton(CANCEL);
    btnCancel.setBounds(135, 80, 110, 30);
    btnCancel.addActionListener(this);
    btnCancel.setEnabled(false);
    panel.add(btnCancel);

    lblDirectory = new JLabel();
    lblDirectory.setBounds(32, 110, 800, 30);
    lblDirectory.setVisible(true);
    panel.add(lblDirectory);


  }

  public void actionPerformed(ActionEvent e) {
    System.out.println("Event    " + e.getActionCommand());

    switch (e.getActionCommand()) {
    case CHOOSE_DIRECTORY:
      System.out.println("Entering case CHOOSE_DIRECTORY");
      String sourceFilePattern = WILDCARD + SOURCE_FILE_SUFFIX_PATTERN;
      File file = chooseDirectory();
      filesFound = null;
      try {
        finder = findFiles(Paths.get(file.getAbsolutePath()), sourceFilePattern);
        filesFound = finder.getMatches().toArray();

      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
      lstFileList = new JList<Object>(filesFound);
      addListToUI();
      break;

    case CANCEL:
      System.out.println("Entering case CANCEL");
      cancel();
      break;
    case COPY:
      System.out.println("Entering case COPY");
      try {
        finder.copySampleFileToPropertiesFile(REMOVE_FROM_FILENAME);
      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
      break;
    default:
      break;
    }
  }

  private void addListToUI() {
    listPane = new JScrollPane();
    lstFileList.setVisibleRowCount(7);
    listPane.setPreferredSize(new Dimension(350, 100));
    listPane.getViewport().setView(lstFileList);
    listContainer = new JPanel();
    listContainer.add(listPane);
    
    frame.getContentPane().add(listContainer, BorderLayout.PAGE_END);
    final int length = filesFound.length;
    frame.setTitle("Copy all " + length + " *.sample files to *.properties files");
    if(length > 0){
      panel.setBackground(Color.RED);
      btnCopy.setEnabled(true);
    }

  }

  private void cancel() {
    panel.setBackground(Color.LIGHT_GRAY);
    lblDirectory.setVisible(false);
    go.setEnabled(true);
    btnCancel.setEnabled(false);
    frame.getContentPane().remove(listContainer);
  }

  private File chooseDirectory() {
    chooser = new JFileChooser();
//    chooser.setCurrentDirectory(new java.io.File("/Users/orestis/Documents/workspace_legic/PROJECTS/superproject/"));
    chooser.setCurrentDirectory(new java.io.File("."));

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
      System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
      return chooser.getSelectedFile();

    } else {
      System.out.println("No Selection ");
      return new File("");
    }
  }

  private FileFinder findFiles(Path startingDir, String pattern) throws IOException {
    return new FileFinder(startingDir, pattern);

  }

  public Dimension getPreferredSize() {
    return new Dimension(1000, 300);
  }

  public static void main(String s[]) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new ConfigurationTool();
      }
    });
  }
  
}