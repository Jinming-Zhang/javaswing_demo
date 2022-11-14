package utils;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class BorderedJPanel extends JPanel {
  public BorderedJPanel(Color c, int size) {
    Border border = BorderFactory.createLineBorder(c, size);
    setBorder(border);
  }
}
