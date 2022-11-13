package layout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.DemoFrame;

import java.awt.*;

public class GridBagLayoutDemo {
  public static void RunDemo() {
    JFrame frame = new DemoFrame();

    frame.getContentPane().setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    // JPanel titleP = new JPanel();
    // titleP.setPreferredSize(new Dimension(1024, 100));
    // titleP.setBackground(Color.cyan);

    // frame.getContentPane().add(titleP);

    c.insets = new Insets(10, 10, 10, 10);
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        c.gridx = i;
        c.gridy = j;
        JPanel cell = new JPanel();
        cell.setPreferredSize(new Dimension(50, 50));
        cell.setBackground(Color.orange);
        frame.getContentPane().add(cell, c);
      }
    }

    frame.pack();
    frame.setVisible(true);
  }
}
