package drawImage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
  public enum Shape {
    Circle,
    Triangle,
    Rectangle,
  }

  Shape toDraw;
  Color c;
  int width;
  int height;

  public PaintPanel(int width, int height, Shape shape, Color c) {
    this.width = width;
    this.height = height;
    this.c = c;
    this.toDraw = shape;
    setPreferredSize(new Dimension(width, height));
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g.setColor(c);
    switch (toDraw) {
      case Circle:
        g2d.fillOval(0, 0, width, height);
        break;
      case Triangle:
        int xPoints[] = { 0, width / 2, width };
        int yPoints[] = { height, 0, height };
        g2d.fillPolygon(xPoints, yPoints, 3);
        break;
      case Rectangle:
        g2d.fillRect(0, 0, width, height);
        break;
      default:
        break;
    }
  }

}
