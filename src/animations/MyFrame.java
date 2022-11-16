package animations;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame {
  MyPanel panel;
  MyFrame(){
    panel =  new MyPanel();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//    this.setSize(500,500);
//    this.setLayout(null);

    this.add(panel);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

//  @Override
//  public void keyTyped(KeyEvent e) {
//
//  }
//
//  @Override
//  public void keyPressed(KeyEvent e) {
//
//  }
//
//  @Override
//  public void keyReleased(KeyEvent e) {
//
//  }
}
