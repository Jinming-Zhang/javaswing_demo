package components;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

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

    addLabelToPanel(greenPanel, true);
    // addLabelToPanel(bluePanel, true);

    // addLabelToPanel(yelloPanel, false);
    // addLabelToPanel(yelloPanel, false);
    // addLabelToPanel(yelloPanel, false);

    frame.add(greenPanel);
    frame.setVisible(true);
  }

  static void addLabelToPanel(JPanel panel, boolean changeLayoutToBorder) {
    if (changeLayoutToBorder) {
      // default is flow layout
      panel.setLayout(new BorderLayout());
    }
    JLabel l = new JLabel("A label");
    l.setIcon(ImageLoader.loadImageIcon("/arts/icons/icon3.png"));

    l.setVerticalAlignment(JLabel.CENTER);
    l.setHorizontalAlignment(JLabel.CENTER);

    l.setVerticalTextPosition(JLabel.TOP);
    l.setHorizontalTextPosition(JLabel.CENTER);

    Border bd = BorderFactory.createLineBorder(Color.red, 1);
    l.setBorder(bd);
    panel.add(l);
  }
}
