package keyevent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

public class GeneralKeyListener implements KeyListener {
  JComponent src;

  public GeneralKeyListener(JComponent src) {
    this.src = src;
  }

  @Override
  public void keyTyped(KeyEvent e) {
    System.out.println(String.format("%s Key Typed: %c", src.getClass().getName(), e.getKeyChar()));
  }

  @Override
  public void keyPressed(KeyEvent e) {
    System.out.println(String.format("%s Key Typed: %c", src.getClass().getName(), e.getKeyChar()));
  }

  @Override
  public void keyReleased(KeyEvent e) {
    System.out.println(String.format("%s Key Typed: %c", src.getClass().getName(), e.getKeyChar()));
  }

}
