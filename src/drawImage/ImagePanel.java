package drawImage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
  BufferedImage img;
  int finalWidth;
  int finalHeight;

  public ImagePanel(String src) {
    try {
      img = ImageIO.read(getClass().getResourceAsStream(src));
      finalWidth = (int) (200.0 / img.getHeight() * img.getWidth());
      finalHeight = (int) (200.0 / img.getHeight() * img.getWidth());
      setPreferredSize(new Dimension(finalWidth, finalHeight));
    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  @Override
  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.drawImage(img, 0, 0, finalWidth, finalHeight, null);
  }

}
