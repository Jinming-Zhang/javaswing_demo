package components;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JFrameDemo {
  public static void RunDemo() {

    JFrame frame = new JFrame("Dungeon");// title
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// exit on close

    configureFrameSize(frame);
    updateFrameIcon(frame, "/arts/icons/icon.jpg");

    configureContentPane(frame);
    // resize size of the frame to fit the content
    frame.pack();
    frame.setVisible(true);// show the gui
  }

  public static void configureFrameSize(JFrame frame) {
    frame.setSize(new Dimension(1366, 768));
    frame.setResizable(false);
  }

  public static void updateFrameIcon(JFrame frame, String path) {
    ImageIcon icon = new ImageIcon(JFrameDemo.class.getResource(path));
    frame.setIconImage(icon.getImage());
  }

  public static void configureContentPane(JFrame frame) {
    frame.getContentPane().setBackground(Color.cyan);
  }
}
