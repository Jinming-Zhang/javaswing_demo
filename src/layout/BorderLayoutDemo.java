package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.BorderedJPanel;
import utils.DemoFrame;

public class BorderLayoutDemo {
  public static void RunDemo() {
    JFrame frame = new DemoFrame();
    frame.setLayout(new BorderLayout());

    JPanel panel1 = new BorderedJPanel(Color.blue, 1);
    JPanel panel2 = new BorderedJPanel(Color.red, 1);
    JPanel panel3 = new BorderedJPanel(Color.yellow, 1);
    JPanel panel4 = new BorderedJPanel(Color.cyan, 1);
    JPanel panel5 = new BorderedJPanel(Color.green, 1);

    panel1.setPreferredSize(new Dimension(100, 100));
    panel1.setBackground(Color.blue);
    frame.add(panel1, BorderLayout.NORTH);

    panel2.setPreferredSize(new Dimension(100, 100));
    panel2.setBackground(Color.red);
    frame.add(panel2, BorderLayout.SOUTH);

    panel3.setBackground(Color.yellow);
    panel3.setPreferredSize(new Dimension(50, 100));
    frame.add(panel3, BorderLayout.EAST);

    panel4.setBackground(Color.cyan);
    panel4.setPreferredSize(new Dimension(50, 100));
    frame.add(panel4, BorderLayout.WEST);

    panel5.setBackground(Color.green);
    panel5.setPreferredSize(new Dimension(100, 100));
    frame.add(panel5, BorderLayout.CENTER);

    frame.setVisible(true);
  }
}
