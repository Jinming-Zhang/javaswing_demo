package drawImage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import drawImage.PaintPanel.Shape;
import utils.DemoFrame;

public class DrawShapeDemo {
  public static void RunDemo() {
    badFrame();
    // maybeGoodFrame();
  }

  static void badFrame() {
    JFrame frame = new BadPaintFrame(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(new Dimension(500, 500));
    frame.setVisible(true);
  }

  static void maybeGoodFrame() {

    JFrame frame = new DemoFrame();

    frame.setLayout(new FlowLayout(20, 20, FlowLayout.LEADING));

    JPanel circle = new PaintPanel(50, 50, Shape.Circle, Color.green);
    JPanel triangle = new PaintPanel(50, 50, Shape.Triangle, Color.green);
    JPanel rect = new PaintPanel(50, 50, Shape.Rectangle, Color.green);

    frame.add(circle);
    frame.add(triangle);
    frame.add(rect);

    Random r = new Random();
    for (int i = 0; i < 40; i++) {
      int g = r.nextInt(3);
      if (g == 0) {
        frame.add(new PaintPanel(50, 50, Shape.Circle, Color.green));
        frame.add(rect);
      }
      if (g == 1) {
        frame.add(new PaintPanel(50, 50, Shape.Triangle, Color.green));
      }
      if (g == 2) {
        frame.add(new PaintPanel(50, 50, Shape.Rectangle, Color.green));
      }
    }

    frame.setVisible(true);
  }
}
