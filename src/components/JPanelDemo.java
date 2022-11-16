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
    // disable the layout for now for demo purpose
    // more on layout later
    frame.setLayout(null);

    // with a customized a bordered panel
    // which has a border
    JPanel bluePanel = new BorderedJPanel(Color.blue, 5);

    // set the position and the size of the label,
    // with top-left being 0 0
    bluePanel.setBounds(0, 0, 250, 250);
    frame.add(bluePanel);

    JPanel yelloPanel = new BorderedJPanel(Color.yellow, 5);
    yelloPanel.setBounds(250, 0, 250, 250);
    frame.add(yelloPanel);

    JPanel greenPanel = new BorderedJPanel(Color.green, 5);
    greenPanel.setBounds(0, 250, 500, 250);

    addLabelToPanel(greenPanel, true);

    // more labels, uncomment the code to see
    // uncomment the code to see
    // uncomment the code to see
    // uncomment the code to see
    // uncomment the code to see
    // uncomment the code to see

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
    // add a lable to the panel
    JLabel l = new JLabel("A label");
    l.setIcon(ImageLoader.loadImageIcon("/arts/icons/icon3.png"));

    // try make some changes
    l.setVerticalAlignment(JLabel.CENTER);
    l.setHorizontalAlignment(JLabel.CENTER);

    l.setVerticalTextPosition(JLabel.TOP);
    l.setHorizontalTextPosition(JLabel.CENTER);

    Border bd = BorderFactory.createLineBorder(Color.red, 1);
    l.setBorder(bd);
    panel.add(l);
  }
}
