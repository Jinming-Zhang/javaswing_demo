package utils;

import javax.swing.ImageIcon;

public class ImageLoader {

  public static ImageIcon loadImageIcon(String path) {
    return new ImageIcon(ImageLoader.class.getResource(path));
  }
}
