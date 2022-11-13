package drawImage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import utils.ImageTransformer;

public class LoopedImagePanel extends JPanel implements ActionListener {
  BufferedImage[] loops;
  int scale;
  Timer timer;
  int index;

  public LoopedImagePanel(int speed, int scale, String... imgs) {
    loops = new BufferedImage[imgs.length];
    timer = new Timer(1000 / speed, this);
    this.scale = scale;
    index = 0;

    for (int i = 0; i < imgs.length; i++) {
      try {
        BufferedImage img = ImageIO.read(getClass().getResourceAsStream(imgs[i]));
        loops[i] = img;
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
    setPreferredSize(new Dimension(scale * loops[0].getWidth(), scale * loops[0].getHeight()));
    timer.start();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.drawImage(loops[index], 0, 0, scale * loops[index].getWidth(), scale * loops[index].getHeight(), null);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    ++index;
    if (index >= loops.length) {
      index = 0;
      for (int i = 0; i < loops.length; i++) {
        loops[i] = ImageTransformer.flipX(loops[i]);
      }
    }
    repaint();
  }
}
