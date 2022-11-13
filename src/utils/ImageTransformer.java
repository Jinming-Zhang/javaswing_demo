package utils;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

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
}
