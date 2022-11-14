package demo;

import drawImage.LoopedImagePanel;
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
  // define rows and columns
  private final int ROW = 8;
  private final int COL = 8;
  
  // define Panel and buttons
  private JPanel gui = new JPanel(new BorderLayout(3, 3));
  private JButton[][] dungeonSpace = new JButton[ROW][COL];
  private JPanel dungeon;
  private DungeonSpace[][] dungeonArray;
  private Position current = new Position(0, 0);
  private boolean wrap = true;
  
  /**
   * default public constructor.
   */
  ReedDemo() {
    this.initializeDungeon();
    this.runGui();
  }
  
  /**
   *  generate a random map using MapGenerator.
   */
  private void initializeDungeon() {
    MapGenerator map = new MapGenerator(this.ROW, this.COL, wrap, 0, 0);
    this.dungeonArray = map.generateMazeSpace();
  }
  
  /**
   * run and generate GUI.
   */
  public final void runGui() {
    drawMaze();
  }

  /**
   * Update GUI as needed.
   */
  public void updateGui() {
    this.gui.removeAll();
    this.drawMaze();
    this.gui.revalidate();
    this.gui.repaint();
  }
  
  /**
   * Draw everything
   */
  private void drawMaze() {
    gui.setBorder(new EmptyBorder(5, 5, 5, 5));
    this.dungeon = new JPanel(new GridLayout(this.ROW, this.COL));
    this.dungeon.setBorder(new LineBorder(Color.BLACK));
    this.gui.add(this.dungeon);
    
    // draw space
    Insets spaceMargin = new Insets(0, 0, 0, 0);
    for (int i = 0; i < this.dungeonSpace.length; i++) {
      for (int j = 0; j < this.dungeonSpace[i].length; j++) {
        // create buttons
        JButton b = new JButton();
        b.setMargin(spaceMargin);
        if (this.current.equals(new Position(i, j))) {
          b.add(new LoopedImagePanel(5, 3, "/arts/characters/player-idle-1.png", "/arts/characters/player-idle-2.png",
              "/arts/characters/player-idle-3.png", "/arts/characters/player-idle-4.png"));
        } else {
          ImageIcon icon = new ImageIcon(
              new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
          b.setIcon(icon);
          b.setBackground(Color.BLACK);
        }
        // save current postion.
        b.putClientProperty(this.current, new Position(i, j));
        
        // add listener.
        b.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            JButton b = (JButton)e.getSource();
            if (b.getBackground().equals(Color.green)) {
              current = (Position) b.getClientProperty(current);
              updateGui();
            }
          }
        });
        
        // add private 2D array variable
        this.dungeonSpace[i][j] = b;
      }
    }
    // change color as needed:
//    this.dungeonSpace[this.current.getRow()][this.current.getCol()].setBackground(Color.blue);
    DungeonSpace current = this.dungeonArray[this.current.getRow()][this.current.getCol()];
    if (current
        .getPathDirection()
        .contains(Direction.NORTH)) {
      int newRow = this.current.getRow() - 1;
      if (newRow == -1) {
        newRow = this.ROW - 1;
      }
      this.dungeonSpace[newRow][this.current.getCol()].setBackground(Color.green);
    }
    if (current
        .getPathDirection()
        .contains(Direction.EAST)) {
      int newCol = this.current.getCol() + 1;
      if (newCol == this.COL) {
        newCol = 0;
      }
      this.dungeonSpace[this.current.getRow()][newCol].setBackground(Color.green);
    }
    if (current
        .getPathDirection()
        .contains(Direction.SOUTH)) {
      int newRow = this.current.getRow() + 1;
      if (newRow == this.ROW) {
        newRow = 0;
      }
      this.dungeonSpace[newRow][this.current.getCol()].setBackground(Color.green);
    }
    if (current
        .getPathDirection()
        .contains(Direction.WEST)) {
      int newCol = this.current.getCol() - 1;
      if (newCol == -1) {
        newCol = this.COL - 1;
      }
      this.dungeonSpace[this.current.getRow()][newCol].setBackground(Color.green);
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
    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    f.setLocationByPlatform(true);
    f.pack();
    
    f.setVisible(true);
  }
  
}
