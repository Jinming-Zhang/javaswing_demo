package demo;

import drawImage.LoopedImagePanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;
import javax.print.DocFlavor.URL;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * ReedDemo class illustrates a dungeon by drawing with Swing.
 * 
 * @author Ruidi Huang
 *
 */

public class ReedDemo {
  // define dungeon map constants.
  private final int ROW = 8;
  private final int COL = 8;
  private final int seed = 0;
  private final int interconnectivity = 0;
  private int treasurePercentage = 20;
  private final Random random = new Random(seed);
  
  // other varibles:
  private int treasureCount = 0;
  
  // define Panel and buttons
  private JPanel gui = new JPanel(new BorderLayout(3, 3));
  private JButton[][] dungeonButtons = new JButton[ROW][COL];
  private JPanel dungeon;
  private JPanel infoDisplay = new JPanel();
  private Position current = new Position(0, 0);
  private DungeonSpace[][] dungeonArray;
  private boolean wrap = true;
  private String playerName = "Wolffurry\n";
  
  // player
  // private Player player;
  
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
    MapGenerator map = new MapGenerator(this.ROW, 
        this.COL, this.wrap, this.interconnectivity, this.seed);
    this.dungeonArray = map.generateMazeSpace();
    this.generateTreasure();
    // this.player = new DungeonPlayer(this.playerName, this.current);
  }
  
  /**
   * add treasures to the dungeon.
   */
  private void generateTreasure() {
    int caveCounter = 0;
    for (DungeonSpace[] d : this.dungeonArray) {
      caveCounter += Arrays.stream(d).filter(i -> i instanceof Cave).count();
    }
    int caveHasTreasure = (int) Math.ceil(caveCounter * this.treasurePercentage / 100.0);
    this.treasureCount = caveHasTreasure;
    while (caveHasTreasure > 0) {
      int row = this.random.nextInt(this.ROW);
      int col = this.random.nextInt(this.COL);
      if (this.dungeonArray[row][col] instanceof Cave) {
        Cave c = (Cave) this.dungeonArray[row][col];
        if (!c.hasTreasure()) {
          c.addTreasure();
          caveHasTreasure -= 1;
        } else {
          c.addTreasure();
        }
      }
    }
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
    this.infoDisplay.removeAll();
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
    for (int i = 0; i < this.dungeonButtons.length; i++) {
      for (int j = 0; j < this.dungeonButtons[i].length; j++) {
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
              // player.moveTo(current);
              updateGui();
            }
          }
        });
        
        // add private 2D array variable
        this.dungeonButtons[i][j] = b;
      }
    }
    // color every valid adjacent dungeon space.
    DungeonSpace current = this.dungeonArray[this.current.getRow()][this.current.getCol()];
    if (current
        .getPathDirection()
        .contains(Direction.NORTH)) {
      int newRow = this.current.getRow() - 1;
      if (newRow == -1) {
        newRow = this.ROW - 1;
      }
      this.dungeonButtons[newRow][this.current.getCol()].setBackground(Color.green);
    }
    if (current
        .getPathDirection()
        .contains(Direction.EAST)) {
      int newCol = this.current.getCol() + 1;
      if (newCol == this.COL) {
        newCol = 0;
      }
      this.dungeonButtons[this.current.getRow()][newCol].setBackground(Color.green);
    }
    if (current
        .getPathDirection()
        .contains(Direction.SOUTH)) {
      int newRow = this.current.getRow() + 1;
      if (newRow == this.ROW) {
        newRow = 0;
      }
      this.dungeonButtons[newRow][this.current.getCol()].setBackground(Color.green);
    }
    if (current
        .getPathDirection()
        .contains(Direction.WEST)) {
      int newCol = this.current.getCol() - 1;
      if (newCol == -1) {
        newCol = this.COL - 1;
      }
      this.dungeonButtons[this.current.getRow()][newCol].setBackground(Color.green);
    }
    // add buttons to dungeon panel.
    for (int i = 0; i < this.ROW; i++) {
      for (int j = 0; j < this.COL; j++) {
        dungeon.add(dungeonButtons[i][j]);
      }
    }
    
    //add treasure at current location to player.
    DungeonSpace currentSpace = 
        this.dungeonArray[this.current.getRow()][this.current.getCol()];
    if (currentSpace.hasTreasure()) {
      for (Treasure t : currentSpace.getTreasure()) {
        // this.player.pickUpTreasure(t);
      }
    }
    
    // adding other components to the gui
    // intialize boxlayout for infoDisplay panel.
    BoxLayout box = new BoxLayout(this.infoDisplay, BoxLayout.Y_AXIS);
    this.infoDisplay.setLayout(box);
    
    // add basic player information
    this.infoDisplay.add(new JLabel(String.format("Player: %s\n", this.playerName)));
    this.infoDisplay.add(new JLabel("\n"));
    this.infoDisplay.add(new JLabel(
        String.format("Position: %s\n", this.current.toString())));
    this.infoDisplay.add(new JLabel("Treasures: \n"));
    this.infoDisplay.add(new JLabel("\n"));
    // Diamond count
    int diamondCount = 0;
    // if (this.player.getTreasure().get(Treasure.DIAMOND) != null) {
    //   diamondCount = this.player.getTreasure().get(Treasure.DIAMOND);
    // }
    this.infoDisplay.add(new JLabel(
        String.format("Diamond --- %d", diamondCount)));
    // Sapphire count
    int sapphireCount = 0;
    // if (this.player.getTreasure().get(Treasure.SAPPHIRE) != null) {
    //   sapphireCount = this.player.getTreasure().get(Treasure.SAPPHIRE);
    // }
    this.infoDisplay.add(new JLabel(
        String.format("Sapphire --- %d", sapphireCount)));
    // Ruby count
    int rubyCount = 0;
    // if (this.player.getTreasure().get(Treasure.RUBY) != null) {
    //   rubyCount = this.player.getTreasure().get(Treasure.RUBY);
    // }
    this.infoDisplay.add(new JLabel(
        String.format("Ruby    ---    %d", rubyCount)));
    
    JTextPane message = new JTextPane();
    if (currentSpace.hasTreasure()) {
      String treasureInfo = "Collected";
      for (Treasure t : currentSpace.getTreasure()) {
        treasureInfo = String.format("%s %s", treasureInfo, t.toString());
      }
      this.dungeonArray[this.current.getRow()][this.current.getCol()].removeTreasures();
      message.setText(treasureInfo);
    }
    this.infoDisplay.add(message);
    
//    this.infoDisplay.add(new JLabel("Treasure at current location:\n"));
//    String treasureInfo = "";
//    DungeonSpace currentSpace = this.dungeonArray[this.current.getRow()][this.current.getCol()];
//    if (currentSpace.getTreasure() != null && !currentSpace.getTreasure().isEmpty()) {
//      for (Treasure t : currentSpace.getTreasure()) {
//        treasureInfo = String.format("%s%s\n", treasureInfo, t.toString());
//      }
//    } else {
//      treasureInfo = String.format("%sNone\n", treasureInfo);
//    }
//    this.infoDisplay.add(new JLabel(treasureInfo));
    this.gui.add(infoDisplay, BorderLayout.LINE_START);
  }
  
  public final JComponent getGui() {
    return this.gui;
  }
  
  public static void main(String[] args) {
    ReedDemo demo = new ReedDemo();
    JFrame f = new JFrame("Project 4 Demo");
    // set frame icon
    java.net.URL imageURL = ReedDemo.class.getResource("/arts/hoyoverseIcon.jpeg");
    ImageIcon frameIcon = new ImageIcon(imageURL);
    f.setIconImage(frameIcon.getImage());
    
    f.add(demo.getGui());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLocationByPlatform(true);
    f.pack();
    
    f.setVisible(true);
  }
  
}
