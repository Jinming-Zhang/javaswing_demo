package keyevent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

public class ListenLabel extends JLabel implements KeyListener {

  public ListenLabel() {
    addKeyListener(this);
  }

  @Override
  public void keyTyped(KeyEvent e) {
    System.out.println(String.format("Label Key Typed: %c", e.getKeyChar()));
  }

  @Override
  public void keyPressed(KeyEvent e) {
    System.out.println(String.format("Label Key Pressed: %c", e.getKeyChar()));
  }

  @Override
  public void keyReleased(KeyEvent e) {
    System.out.println(String.format("Label Key Released: %c", e.getKeyChar()));
  }

}
