package drawImage;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class BadPaintFrame extends JFrame {
  int width;
  int height;

  public BadPaintFrame(int width, int height) {
    this.width = width;
    this.height = height;
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(new BasicStroke(5));
    g2d.drawLine(0, 0, width, height);
  }
}
