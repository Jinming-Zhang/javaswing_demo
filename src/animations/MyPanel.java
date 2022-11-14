package animations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {

  final int PANEL_WIDTH = 500;
  final int PANEL_HEIGHT = 500;
  Image enemy;
  Image bgImage;
  Timer timer;
  int xVelocity = 1;
  int yVelocity = 1;
  int x = 0;
  int y = 0;

  MyPanel(){
    this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    this.setBackground(Color.BLACK);
    enemy = new ImageIcon("src/arts/naruto/naruto.png").getImage().getScaledInstance(100,100,100);
    timer = new Timer(1000, null);
  }

public void paint(Graphics g){
    Graphics2D g2D = (Graphics2D) g;
    g2D.drawImage(enemy,x,y,null);
}


  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
