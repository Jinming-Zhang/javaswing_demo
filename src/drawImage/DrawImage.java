package drawImage;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

import layout.GridBagLayoutDemo;

import java.awt.*;
import utils.DemoFrame;

public class DrawImage {
  public static void RunDemo() {
    JFrame frame = new DemoFrame();
    frame.getContentPane().setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.ipadx = 30;
    c.ipady = 30;
    c.gridx = 0;
    c.gridy = 0;
    frame.getContentPane().setPreferredSize(new Dimension(1000, 1000));
    JPanel p1 = new ImagePanel("/arts/wow1.jpg");
    frame.getContentPane().add(p1, c);
    c.gridx = 1;
    frame.getContentPane().add(new ImagePanel("/arts/wow2.jpg"), c);
    c.gridx = 0;
    c.gridy = 1;
    frame.getContentPane().add(new ImagePanel("/arts/wow3.jpg"), c);
    c.gridx = 1;
    frame.getContentPane().add(new ImagePanel("/arts/wow4.jpg"), c);
    c.gridx = 0;
    c.gridy = 2;
    frame.getContentPane().add(new ImagePanel("/arts/wow5.jpg"), c);
    c.gridx = 2;
    c.gridy = 2;

    frame.getContentPane()
        .add(new LoopedImagePanel(5, 3, "/arts/characters/player-idle-1.png", "/arts/characters/player-idle-2.png",
            "/arts/characters/player-idle-3.png", "/arts/characters/player-idle-4.png"), c);

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
