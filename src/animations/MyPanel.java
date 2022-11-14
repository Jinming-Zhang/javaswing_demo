package animations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel implements ActionListener {

  final int PANEL_WIDTH = 500;
  final int PANEL_HEIGHT = 500;
  Image naruto;
  Image naruto2;
  Image bgImage;
  Timer timer;
  int xVelocity = 1;
  int yVelocity = 1;
  int x = 0;
  int y = 400;

  MyPanel(){
    this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    this.setBackground(Color.BLACK);
    naruto = new ImageIcon("src/arts/naruto/naruto.png").getImage().getScaledInstance(100,100,0);

    naruto2 = new ImageIcon("src/arts/naruto/naruto_2.png").getImage().getScaledInstance(100,100,0);

    timer = new Timer(5, this);
    timer.start();
  }

public void paint(Graphics g){
    super.paint(g);
    Graphics2D g2D = (Graphics2D) g;
    g2D.drawImage(naruto,x,y,null);

    g2D.drawImage(naruto2, x+250, y, null);
}


  @Override
  public void actionPerformed(ActionEvent e) {
    if (x>=PANEL_WIDTH - naruto.getWidth(null) || x < 0){
      xVelocity *= -1;
    }
    x += xVelocity;
    repaint();
  }
}
