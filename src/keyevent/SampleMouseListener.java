package keyevent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import commands.PlaySoundCommand;
import utils.ImageLoader;
import utils.ImageTransformer;

public class SampleMouseListener implements MouseListener {

  String hahaha[] = { "/audio/teemo_4.wav", "/audio/Teemo.laugh1.wav", "/audio/Teemo.laugh2.wav" };
  String enteredEmo = "/arts/icons/shocked.png";
  String exitEmo = "/arts/icons/thinking.png";
  String clickEmo = "/arts/icons/teewow.png";

  @Override
  public void mouseClicked(MouseEvent e) {
    if (e.getSource() instanceof JLabel) {
      JLabel l = (JLabel) e.getSource();
      setLabelIcon(l, clickEmo);
      Random r = new Random();
      new PlaySoundCommand(hahaha[r.nextInt(hahaha.length)]).Execute();;
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {
    if (e.getSource() instanceof JLabel) {
      JLabel l = (JLabel) e.getSource();
      setLabelIcon(l, enteredEmo);
    }
  }

  @Override
  public void mouseExited(MouseEvent e) {
    if (e.getSource() instanceof JLabel) {
      JLabel l = (JLabel) e.getSource();
      setLabelIcon(l, exitEmo);
    }
  }

  void setLabelIcon(JLabel label, String path) {
    ImageIcon icon = ImageLoader.loadImageIcon(path);
    icon = ImageTransformer.scaleTo(icon, label.getPreferredSize().height);
    label.setIcon(icon);
  }
}
