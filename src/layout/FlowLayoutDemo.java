package layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import commands.PlaySoundCommand;
import components.CommandJBtn;
import utils.BorderedJPanel;
import utils.DemoFrame;

/**
 * FlowLayoutDemo
 */
public class FlowLayoutDemo {
  public static void RunDemo() {
    JFrame frame = new DemoFrame();

    frame.setLayout(new FlowLayout(FlowLayout.LEADING));

    frame.add(new JButton("Button 1"));

    JPanel panel = new BorderedJPanel(Color.blue, 2);
    panel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));
    panel.setPreferredSize(new Dimension(500, 500));

    frame.add(panel);

    panel.add(new CommandJBtn("Button 2", new PlaySoundCommand("/audio/Teemo.taunt.wav")));
    panel.add(new CommandJBtn("Button 3", new PlaySoundCommand("/audio/teemo_4.wav")));
    panel.add(new CommandJBtn("Button 4", new PlaySoundCommand("/audio/Teemo.attack1.wav")));
    panel.add(new CommandJBtn("Button 5", new PlaySoundCommand("/audio/Teemo.attack2.wav")));
    panel.add(new CommandJBtn("Button 6", new PlaySoundCommand("/audio/Teemo.laugh1.wav")));
    panel.add(new CommandJBtn("Button 7", new PlaySoundCommand("/audio/Teemo.laugh2.wav")));
    panel.add(new CommandJBtn("Button 8", new PlaySoundCommand("/audio/Teemo.taunt.wav")));
    panel.add(new CommandJBtn("Button 9", new PlaySoundCommand("/audio/button_click.wav")));

    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
