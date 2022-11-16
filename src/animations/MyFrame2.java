package animations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame2 extends JFrame implements KeyListener, ActionListener, MouseListener {

  final int FRAME_WIDTH = 500;
  final int FRAME_HEIGHT = 500;

  JLabel l1;
  JLabel l2;



  MyFrame2(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
    this.setLayout(null);
    this.addKeyListener(this);

    l1 = new JLabel();
    l1.setBounds(0,0,100,100);;
    l1.setBackground(Color.red);
    l1.setOpaque(true);
    l1.addMouseListener(this);
    this.add(l1);



    this.setVisible(true);
  }

  @Override
  public void keyTyped(KeyEvent e) {
    switch (e.getKeyChar()){
      case 'a':
        l1.setLocation(l1.getX() - 5, l1.getY());
        break;
      case 'w':
        l1.setLocation(l1.getX(), l1.getY() - 5);
        break;
      case 's':
        l1.setLocation(l1.getX(), l1.getY() + 5);
        break;
      case 'd':
        l1.setLocation(l1.getX() + 5, l1.getY());
        break;
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }



  @Override
  public void actionPerformed(ActionEvent e) {

//    if (x>=FRAME_WIDTH - l1.getWidth() || x < 0){
//      xVelocity *= -1;
//    }
//    x += xVelocity;
//
//    if (y>=FRAME_HEIGHT - l1.getHeight() || y < 0){
//      yVelocity *= -1;
//    }
//    y += yVelocity;
//
//    repaint();

  }


  public void paint(Graphics g){
//    super.paint(g);
//    Graphics2D g2D = (Graphics2D) g;
//    g2D.drawRect(0,200,100,100);

    //    g2D.drawImage(naruto2, x+250, y, null);
  }

  @Override
  public void mouseClicked(MouseEvent e) {
//    System.out.println("clicked the label");
    l1.setBackground(randomColor());
  }

  @Override
  public void mousePressed(MouseEvent e) {

  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }

  public Color randomColor(){
    int r = (int)(Math.random()*256);
    int g = (int)(Math.random()*256);
    int b = (int)(Math.random()*256);
    return (new Color(r,g,b));
  }
}
