package animations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements ActionListener, KeyListener {

  final int PANEL_WIDTH = 500;
  final int PANEL_HEIGHT = 500;
  Image naruto;
  Image naruto2;
  Image bgImage;
  Timer timer;
  int xVelocity = 2;
  int yVelocity = 1;
  int x = 0;
  int y = 200;

  MyPanel(){
    this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    this.setBackground(Color.BLACK);
//    this.addKeyListener(this);
    naruto = new ImageIcon("src/arts/naruto/naruto.png").getImage().getScaledInstance(100,100,0);

    naruto2 = new ImageIcon("src/arts/naruto/naruto_2.png").getImage().getScaledInstance(100,100,0);

    timer = new Timer(10, this);
    timer.start();
  }

public void paint(Graphics g){
    super.paint(g);
    Graphics2D g2D = (Graphics2D) g;
    g2D.drawImage(naruto,x,y,null);

//    g2D.drawImage(naruto2, x+250, y, null);
}


  @Override
  public void actionPerformed(ActionEvent e) {

    if (x>=PANEL_WIDTH - naruto.getWidth(null) || x < 0){
      xVelocity *= -1;
    }
    x += xVelocity;

    if (y>=PANEL_HEIGHT - naruto.getHeight(null) || y < 0){
      yVelocity *= -1;
    }
    y += yVelocity;

    repaint();
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {
    System.out.println("Key char: "+e.getKeyChar());
  }
}
