package utils;

import java.awt.GraphicsEnvironment;

public class ShowFont {
  public static void printFonts() {

    String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    for (String font : fonts) {
      System.out.println(font);
    }
  }
}
