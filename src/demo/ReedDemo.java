package demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * ReedDemo class illustrates a dungeon by drawing with Swing.
 * 
 * @author Ruidi Huang
 *
 */

public class ReedDemo {
  
  private final int ROW = 6;
  private final int COL = 8;
  
  private JPanel gui = new JPanel(new BorderLayout(3, 3));
  private JButton[][] dungeonSpace = new JButton[ROW][COL];
  private JPanel dungeon;
  private DungeonSpace[][] dungeonArray;
  private Position current = new Position(0, 0);
  
  ReedDemo() {
    this.initializeDungeon();
    this.runGui();
  }
  
  // generate a random map using MapGenerator.
  private void initializeDungeon() {
    MapGenerator map = new MapGenerator(this.ROW, this.COL, false, 0, 0);
    this.dungeonArray = map.generateMazeSpace();
  }
  
  public final void runGui() {
    drawMaze();
  }

  public void updateGui() {
    System.out.println("!");
    this.gui.removeAll();
    this.drawMaze();
    this.gui.revalidate();
    this.gui.repaint();
  }
  
  private void drawMaze() {
    gui.setBorder(new EmptyBorder(5, 5, 5, 5));
    this.dungeon = new JPanel(new GridLayout(this.ROW, this.COL));
    this.dungeon.setBorder(new LineBorder(Color.BLACK));
    this.gui.add(this.dungeon);
    
    // draw space
    Insets spaceMargin = new Insets(0, 0, 0, 0);
    for (int i = 0; i < this.dungeonSpace.length; i++) {
      for (int j = 0; j < this.dungeonSpace[i].length; j++) {
        JButton b = new JButton();
        b.setMargin(spaceMargin);
        ImageIcon icon = new ImageIcon(
            new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
        b.setIcon(icon);
        b.setBackground(Color.WHITE);
        this.dungeonSpace[i][j] = b;
//        b.addActionListener(new ActionListener() {
//          @Override
//          public void actionPerformed(ActionEvent e) {
//            if (b.getBackground().equals(Color.yellow)) {
//              b.setBackground(Color.BLUE);
//              b.revalidate();
//              b.repaint();
//            }
//          }
//        });
      }
    }
    
    // change color as needed:
    this.dungeonSpace[this.current.getRow()][this.current.getCol()].setBackground(Color.blue);
    DungeonSpace current = this.dungeonArray[this.current.getRow()][this.current.getCol()];
    if (current
        .getPathDirection()
        .contains(Direction.NORTH)) {
      this.dungeonSpace[this.current.getRow() - 1][this.current.getCol()].setBackground(Color.yellow);
    }
    if (current
        .getPathDirection()
        .contains(Direction.EAST)) {
      this.dungeonSpace[this.current.getRow()][this.current.getCol() + 1].setBackground(Color.yellow);
    }
    if (current
        .getPathDirection()
        .contains(Direction.SOUTH)) {
      this.dungeonSpace[this.current.getRow() + 1][this.current.getCol()].setBackground(Color.yellow);
    }
    if (current
        .getPathDirection()
        .contains(Direction.WEST)) {
      this.dungeonSpace[this.current.getRow()][this.current.getCol() - 1].setBackground(Color.yellow);
    }
    
    
    
    // add space
    for (int i = 0; i < this.ROW; i++) {
      for (int j = 0; j < this.COL; j++) {
        dungeon.add(dungeonSpace[i][j]);
      }
    }
  }
  
  public final JComponent getGui() {
    return this.gui;
  }
  
  public static void main(String[] args) {
    ReedDemo demo = new ReedDemo();
    JFrame f = new JFrame("Test");
    f.add(demo.getGui());
    f.setSize(600, 600);
    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f.setLocationByPlatform(true);
    f.pack();
    
    f.setVisible(true);
  }
  
}
