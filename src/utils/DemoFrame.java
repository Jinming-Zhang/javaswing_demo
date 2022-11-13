package utils;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DemoFrame extends JFrame {

  public DemoFrame() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(new Dimension(1366, 768));
    setResizable(false);
    ImageIcon icon = new ImageIcon(getClass().getResource("/arts/icons/icon.jpg"));
    setIconImage(icon.getImage());
    getContentPane().setBackground(Color.cyan);
  }
}
