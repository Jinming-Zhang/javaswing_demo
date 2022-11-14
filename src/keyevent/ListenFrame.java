package keyevent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class ListenFrame extends JFrame implements KeyListener {
  public ListenFrame() {
    addKeyListener(this);
  }

  @Override
  public void keyTyped(KeyEvent e) {
    System.out.println(String.format("Frame Key Typed: %c", e.getKeyChar()));
  }

  @Override
  public void keyPressed(KeyEvent e) {
    System.out.println(String.format("Frame Key Pressed: %c", e.getKeyChar()));
  }

  @Override
  public void keyReleased(KeyEvent e) {
    System.out.println(String.format("Frame Key Released: %c", e.getKeyChar()));
  }

}
