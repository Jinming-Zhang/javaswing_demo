package layout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.BorderedJPanel;
import utils.DemoFrame;

import java.awt.*;

public class GridBagLayoutDemo {
  public static void RunDemo() {
    JFrame frame = new DemoFrame();

    frame.getContentPane().setLayout(new GridBagLayout());
    var pane = frame.getContentPane();
    GridBagConstraints c = new GridBagConstraints();

    JPanel titleP = new JPanel();
    titleP.setBackground(Color.blue);
    c.gridx = 0;
    c.gridy = 0;
    c.fill = GridBagConstraints.BOTH;
    c.gridwidth = 2;
    c.weighty = 1;
    pane.add(titleP, c);
    c.gridwidth = 1;

    c.gridx = 0;
    c.gridy = 1;
    c.weightx = 1;
    c.weighty = 3;
    JPanel portraitP = new BorderedJPanel(Color.cyan, 4);
    pane.add(portraitP, c);

    c.gridx = 0;
    c.gridy = 2;
    c.weighty = 2;
    JPanel statusP = new BorderedJPanel(Color.yellow, 4);
    pane.add(statusP, c);

    c.gridx = 1;
    c.gridy = 1;
    c.weightx = 2;
    c.weighty = 5;
    c.gridheight = 2;
    JPanel mazeP = new BorderedJPanel(Color.red, 4);
    pane.add(mazeP, c);

    // c.insets = new Insets(10, 10, 10, 10);
    // for (int i = 0; i < 4; i++) {
    // for (int j = 0; j < 4; j++) {
    // c.gridx = i;
    // c.gridy = j;
    // JPanel cell = new JPanel();
    // cell.setPreferredSize(new Dimension(50, 50));
    // cell.setBackground(Color.orange);
    // frame.getContentPane().add(cell, c);
    // }
    // }

    frame.setVisible(true);
  }
}
