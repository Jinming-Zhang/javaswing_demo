package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.BorderedJPanel;
import utils.DemoFrame;

/**
 * FlowLayoutDemo
 */
public class FlowLayoutDemo {
  public static void RunDemo() {
    JFrame frame = new DemoFrame();

    frame.setLayout(new FlowLayout(FlowLayout.LEADING));

    frame.add(new JButton("Button 1"));

    JPanel panel = new BorderedJPanel(Color.blue, 2);
    panel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));
    panel.setPreferredSize(new Dimension(500, 500));

    frame.add(panel);
    panel.add(new JButton("Button 2"));
    panel.add(new JButton("Button 3"));
    panel.add(new JButton("Button 4"));
    panel.add(new JButton("Button 5"));
    panel.add(new JButton("Button 6"));
    panel.add(new JButton("Button 7"));
    panel.add(new JButton("Button 8"));
    panel.add(new JButton("Button 9"));

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
