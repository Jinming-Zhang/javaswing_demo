package utils;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class ImageTransformer {
  public static BufferedImage flipX(BufferedImage img) {
    AffineTransform at = AffineTransform.getScaleInstance(-1, 1);
    at.translate(-img.getWidth(null), 0);
    AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
    return op.filter(img, null);
  }

  public static BufferedImage flipY(BufferedImage img) {
    AffineTransform at = AffineTransform.getScaleInstance(1, -1);
    at.translate(0, -img.getHeight(null));
    AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
    return op.filter(img, null);
  }

  public static ImageIcon scaleTo(ImageIcon img, int height) {
    int currentHeight = img.getImage().getHeight(null);
    double scale = (double)height / currentHeight;
    int newWidth = (int) (img.getImage().getWidth(null) * scale);
    int newHeight = (int) (img.getImage().getHeight(null) * scale);
    Image image = img.getImage(); // transform it
    Image newimg = image.getScaledInstance(newWidth, newHeight, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
    return new ImageIcon(newimg);
  }
}
