package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import utils.DemoFrame;
import utils.ImageLoader;

/**
 * 
 */
public class JLabelDemo {

  public static void RunDemo() {
    JFrame frame = new DemoFrame();

    JLabel label = new JLabel("Yoooooooooo broooooo");

    setLabelImage(label, "/arts/icons/doggy.gif");

    setLabelTextPosition(label);

    setLabelFont(label);

    setTextImageGap(label);

    checkBoarder(label);

    setLabelContentAlignment(label);
    frame.getContentPane().add(label);
    frame.pack();
    frame.setVisible(true);
  }

  static void setLabelImage(JLabel label, String path) {
    ImageIcon i = ImageLoader.loadImageIcon(path);
    label.setIcon(i);
  }

  static void setLabelTextPosition(JLabel label) {
    label.setHorizontalTextPosition(JLabel.CENTER);
    label.setVerticalTextPosition(JLabel.TOP);
  }

  static void setLabelFont(JLabel label) {
    label.setForeground(Color.blue);
    label.setFont(new Font("MV Boli", Font.PLAIN, 20));
  }

  private static void setTextImageGap(JLabel label) {
    label.setIconTextGap(10);
  }

  private static void checkBoarder(JLabel label) {
    Border border = BorderFactory.createLineBorder(Color.blue, 10);
    label.setBorder(border);
  }

  private static void setLabelContentAlignment(JLabel label) {
    label.setVerticalAlignment(JLabel.CENTER);
    label.setHorizontalAlignment(JLabel.CENTER);
  }
}
