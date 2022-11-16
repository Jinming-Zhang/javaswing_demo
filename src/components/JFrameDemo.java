package components;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JFrameDemo {
  public static void RunDemo() {
    // how to set title
    JFrame frame = new JFrame("Dungeon");

    // exit on close, otherwise the program will keep running after the frame is
    // closed
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // some example on configuring the frame
    configureFrameSize(frame);

    // customize frame icon
    updateFrameIcon(frame, "/arts/icons/icon.jpg");

    // customize the contentpane of the frame
    configureContentPane(frame);

    // this will resize the frame to fit the content
    // without this the frame will maintain it's configured size
    // frame.pack();

    // show the frame
    frame.setVisible(true);
  }

  public static void configureFrameSize(JFrame frame) {
    frame.setSize(new Dimension(500, 500));
    // this will make the frame un resizable
    frame.setResizable(false);
  }

  public static void updateFrameIcon(JFrame frame, String path) {
    // load the icon and then set
    ImageIcon icon = new ImageIcon(JFrameDemo.class.getResource(path));
    frame.setIconImage(icon.getImage());
  }

  public static void configureContentPane(JFrame frame) {
    // one simple configuration for background, this is common for all JComponent
    frame.getContentPane().setBackground(Color.cyan);
  }
}
