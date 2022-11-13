package layout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;

public class GridBagLayoutDemo {
  public static void RunDemo() {
    JFrame frame = new JFrame();

    frame.getContentPane().setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = 0;

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {

      }

    }
    JPanel titleP = new JPanel();
    titleP.setPreferredSize(new Dimension(1024, 100));
    titleP.setBackground(Color.cyan);
    frame.getContentPane().add(titleP);

    frame.pack();
    frame.setVisible(true);
  }
}
