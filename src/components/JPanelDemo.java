package components;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.BorderedJPanel;
import utils.DemoFrame;
import utils.ImageLoader;

public class JPanelDemo {
  public static void RunDemo() {
    JFrame frame = new DemoFrame();
    frame.setLayout(null);

    JPanel bluePanel = new BorderedJPanel(Color.blue, 5);
    bluePanel.setBounds(0, 0, 250, 250);
    frame.add(bluePanel);

    JPanel yelloPanel = new BorderedJPanel(Color.yellow, 5);
    yelloPanel.setBounds(250, 0, 250, 250);
    frame.add(yelloPanel);

    JPanel greenPanel = new BorderedJPanel(Color.green, 5);
    greenPanel.setBounds(0, 250, 500, 250);

    addLabelToPanel(greenPanel);

    frame.add(greenPanel);
    frame.setVisible(true);
  }

  static void addLabelToPanel(JPanel panel) {
    JLabel l = new JLabel("A label");
    l.setIcon(ImageLoader.loadImageIcon("/arts/icons/icon3.png"));

    l.setVerticalTextPosition(JLabel.CENTER);
    panel.add(l);
  }
}
