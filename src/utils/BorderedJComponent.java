package utils;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

public abstract class BorderedJComponent extends JComponent {
  public BorderedJComponent(Color borderClr, int size) {
    Border border = BorderFactory.createLineBorder(borderClr, size);
    setBorder(border);
  }
}
