package components;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import commands.PlaySoundCommand;
import utils.DemoFrame;

public class JMenuDemo {
  public static void RunDemo() {
    JFrame frame = new DemoFrame();
    frame.setSize(new Dimension(500, 500));
    frame.setTitle("Dungeon");

    addMenubar(frame);

    addMenu(frame);
    frame.setVisible(true);
  }

  static void addMenubar(JFrame frame) {
    JMenuBar menubar = new JMenuBar();

    JMenu fileMenu = new JMenu("File");
    JMenu editMenu = new JMenu("Edit");
    JMenu helpMenu = new JMenu("Help");

    JMenuItem loadItem = new JMenuItem("Load");
    loadItem.addActionListener(new PlaySoundCommand("/audio/Teemo.taunt.wav"));
    JMenuItem saveItem = new JMenuItem("Save");
    saveItem.addActionListener(new PlaySoundCommand("/audio/Teemo.attack1.wav"));
    JMenuItem exitItem = new JMenuItem("Exit");
    exitItem.addActionListener(new PlaySoundCommand("/audio/Teemo.attack2.wav"));

    fileMenu.add(loadItem);
    fileMenu.add(saveItem);
    fileMenu.add(exitItem);

    menubar.add(fileMenu);
    menubar.add(editMenu);
    menubar.add(helpMenu);
    frame.setJMenuBar(menubar);
  }

  static void addMenu(JFrame frame) {

  }
}
