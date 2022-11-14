package components;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import utils.AudioPlayer;
import utils.DemoFrame;
import utils.ImageLoader;

public class JButtonDemo {
  public static void RunDemo() {
    JFrame frame = new DemoFrame();
    frame.setLayout(null);

    JButton btn = new JButton();
    btn.setText("Boop");
    btn.setBounds(100, 100, 450, 250);

    decorateBtn(btn);

    addButtonCallback(btn);
    frame.getContentPane().add(btn);
    frame.setVisible(true);
  }

  static void decorateBtn(JButton btn) {
    btn.setFocusable(false);

    ImageIcon icon = ImageLoader.loadImageIcon("/arts/icons/realIcon.png");
    btn.setIcon(icon);

    btn.setHorizontalTextPosition(JButton.CENTER);
    btn.setVerticalTextPosition(JButton.TOP);

    btn.setFont(new Font("Comic Sans", Font.BOLD, 25));
    btn.setIconTextGap(10);

    btn.setBackground(Color.ORANGE);
  }

  private static void addButtonCallback(JButton btn) {
    // teemo_4.wav
    btn.addActionListener(e -> {
      AudioPlayer.playSFX("/audio/teemo_4.wav");
    });
  }
}
