package eu.salingers.tooling.files.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import eu.salingers.tooling.files.FileFinder;

import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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

  private JLabel lblDisplay;

  private JButton btnCancel;

  private JButton btnCopy;

  private JList<Object> lstFileList = new JList<>();

  private JScrollPane scrollPane;

  private JFrame frame = new JFrame();

  private JPanel panel = new JPanel();

  private Object[] filesFound;

  private FileFinder finder;

  private JPanel listContainer;

  public ConfigurationTool() {
    addComponentsToPanel();
    addUIPanelToFrame();
    addListPanelToFrame();
    setUpFrame();
  }

  private void addUIPanelToFrame() {
    frame.getContentPane().add(panel, "Center");
  }

  private void setUpFrame() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EDIT
    frame.setSize(panel.getPreferredSize());
    frame.setTitle(".property File Tool");
    frame.setVisible(true);
  }

  private void addComponentsToPanel() {
    panel.setSize(new Dimension(800, 250));

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

    lblDisplay = new JLabel();
    lblDisplay.setVerticalAlignment(SwingConstants.TOP);
    lblDisplay.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
    lblDisplay.setBounds(257, 35, 517, 64);
    lblDisplay.setVisible(true);
    panel.add(lblDisplay);

  }

  private void addListPanelToFrame() {
    
    listContainer = new JPanel();
    listContainer.setBorder(UIManager.getBorder("List.evenRowBackgroundPainter"));
    listContainer.setBackground(Color.YELLOW);
    listContainer.setPreferredSize(new Dimension(100, 100));
    frame.getContentPane().add(listContainer, BorderLayout.AFTER_LAST_LINE);
    lstFileList.setVisibleRowCount(3);
    GridBagLayout gbl_listContainer = new GridBagLayout();
    gbl_listContainer.columnWeights = new double[]{1.0};
    gbl_listContainer.rowWeights = new double[]{0.0};
    listContainer.setLayout(gbl_listContainer);
    
    scrollPane = new JScrollPane();
    scrollPane.setViewportBorder(UIManager.getBorder("List.sourceListFocusedSelectionBackgroundPainter"));
    scrollPane.setPreferredSize(new Dimension(650, 75));
    GridBagConstraints gbc_scrollPane = new GridBagConstraints();
    gbc_scrollPane.fill = GridBagConstraints.VERTICAL;
    gbc_scrollPane.insets = new Insets(0, 30, 0, 0);
    gbc_scrollPane.anchor = GridBagConstraints.WEST;
    gbc_scrollPane.gridx = 0;
    gbc_scrollPane.gridy = 0;
    listContainer.add(scrollPane, gbc_scrollPane);
    
  }

  public void actionPerformed(ActionEvent e) {
    System.out.println("Event    " + e.getActionCommand());

    switch (e.getActionCommand()) {
    case CHOOSE_DIRECTORY:
      System.out.println("Entering case CHOOSE_DIRECTORY");
      String sourceFilePattern = WILDCARD + SOURCE_FILE_SUFFIX_PATTERN;
      File file = chooseDirectory();
      if (file.exists()) {
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
      }
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
    
    // lstFileList.setBounds(100,0,200,200);
    scrollPane.getViewport().setView(lstFileList);

    final int length = filesFound.length;
    frame.setTitle("Copy all " + length + " *.sample files to *.properties files");
    if (length > 0) {
      panel.setBackground(Color.RED);
      btnCopy.setEnabled(true);
    }
    listContainer.repaint();

  }

  private void cancel() {
    finder.emptyFileList();
    panel.setBackground(Color.LIGHT_GRAY);
    lblDisplay.setVisible(false);
    go.setEnabled(true);
    btnCancel.setEnabled(false);
    listContainer.remove(scrollPane);
    listContainer.repaint();
  }

  private File chooseDirectory() {
    chooser = new JFileChooser();
    // chooser.setCurrentDirectory(new
    // java.io.File("/Users/orestis/Documents/workspace_legic/PROJECTS/superproject/"));
    chooser.setCurrentDirectory(new java.io.File("."));

    chooser.setDialogTitle(choosertitle);
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setFileHidingEnabled(true);
    // disable the "All files" option.
    chooser.setAcceptAllFileFilterUsed(false);
    
    if (chooser.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION) {

      lblDisplay.setVisible(true);
      go.setEnabled(false);
      btnCancel.setVisible(true);
      btnCancel.setEnabled(true);

      lblDisplay.setText(chooser.getSelectedFile().toString());
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
    return new Dimension(800, 300);
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