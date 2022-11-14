package keyevent;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import utils.DemoFrame;
import utils.ImageLoader;

public class KeyeventDemo {
  public static void RunDemo() {
    JFrame frame = new ListenFrame();
    frame.setLayout(new FlowLayout());

    JLabel lb = new ListenLabel();
    lb.setPreferredSize(new Dimension(150, 150));
    lb.setIcon(ImageLoader.loadImageIcon("/arts/icons/icon3.png"));
    lb.setFocusable(true);
    frame.add(lb);

    JButton btn = new JButton("B1");
    btn.addKeyListener(new GeneralKeyListener(btn));
    frame.add(btn);

    lb.addMouseListener(new SampleMouseListener());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setSize(new Dimension(500, 500));
    frame.setVisible(true);
  }
}
