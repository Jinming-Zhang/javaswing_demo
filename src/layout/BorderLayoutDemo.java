package layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.BorderedJPanel;
import utils.DemoFrame;

public class BorderLayoutDemo {
  public static void RunDemo() {
    JFrame frame = new DemoFrame();

    // this is how to set a layout to a JComponent, not just JFrame
    frame.setLayout(new BorderLayout());

    // panels to be added
    JPanel panel1 = new BorderedJPanel(Color.blue, 1);
    JPanel panel2 = new BorderedJPanel(Color.red, 1);
    JPanel panel3 = new BorderedJPanel(Color.yellow, 1);
    JPanel panel4 = new BorderedJPanel(Color.cyan, 1);
    JPanel panel5 = new BorderedJPanel(Color.green, 1);

    // set preference size of width 100, height 100
    panel1.setPreferredSize(new Dimension(100, 100));
    panel1.setBackground(Color.blue);
    // place it at the top, note when streching the frame it only expends on the
    // horizontal direction
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
