package keyevent;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import utils.ImageLoader;
import utils.ImageTransformer;

public class SampleMouseListener implements MouseListener {

  String enteredEmo = "/arts/icons/shocked.png";
  String exitEmo = "/arts/icons/thinking.png";
  String clickEmo = "/arts/icons/teewow.png";

  @Override
  public void mouseClicked(MouseEvent e) {
    if (e.getSource() instanceof JLabel) {
      JLabel l = (JLabel) e.getSource();
      ImageIcon icon = ImageLoader.loadImageIcon(enteredEmo);
      icon = ImageTransformer.scaleTo(icon, l.getPreferredSize().height);
      l.setIcon(icon);
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub

  }

}
