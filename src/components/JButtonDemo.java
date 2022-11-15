package components;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import commands.EasterneggBtCmd;
import commands.PlaySoundCommand;
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

    // a simple customized Jbutton with a preset command
    JButton cbtn = new CommandJBtn(new PlaySoundCommand("/audio/Teemo.laugh1.wav"));
    cbtn.setBounds(700, 100, 150, 150);
    frame.add(cbtn);

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
    EasterneggBtCmd bcmd = new EasterneggBtCmd(new String[] { "/audio/teemo_4.wav" }, 10);
    btn.addActionListener(e -> {
      bcmd.Execute();
    });
  }
}
