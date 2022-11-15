package demo;

import drawImage.LoopedImagePanel;
import utils.ImageLoader;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

import commands.PlaySoundCommand;

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
  private String playerName = "ReedGod\n";

  // player
  private Player player;

  /**
   * default public constructor.
   */
  ReedDemo() {
    this.initializeDungeon();
    this.runGui();
  }

  /**
   * generate a random map using MapGenerator.
   */
  private void initializeDungeon() {
    MapGenerator map = new MapGenerator(this.ROW,
        this.COL, this.wrap, this.interconnectivity, this.seed);
    this.dungeonArray = map.generateMazeSpace();
    this.generateTreasure();
    this.player = new DungeonPlayer(this.playerName, this.current);
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
          int index = (i + j) % 7;
          java.net.URL imageURL = null;
          switch (index) {
            case 0:
              imageURL = ReedDemo.class.getResource("/arts/pyro.png");
              break;
            case 1:
              imageURL = ReedDemo.class.getResource("/arts/hydro.png");
              break;
            case 2:
              imageURL = ReedDemo.class.getResource("/arts/anemo.png");
              break;
            case 3:
              imageURL = ReedDemo.class.getResource("/arts/electro.png");
              break;
            case 4:
              imageURL = ReedDemo.class.getResource("/arts/dendro.png");
              break;
            case 5:
              imageURL = ReedDemo.class.getResource("/arts/cryo.png");
              break;
            case 6:
              imageURL = ReedDemo.class.getResource("/arts/geo.png");
              break;
          }
          ImageIcon icon = new ImageIcon(imageURL);
          b.setIcon(icon);
          b.setBackground(Color.DARK_GRAY);
        }
        // save current postion.
        b.putClientProperty(this.current, new Position(i, j));

        // add listener.
        b.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            if (b.getBackground().equals(Color.pink)) {
              current = (Position) b.getClientProperty(current);
              player.moveTo(current);
              updateGui();
            }
            new PlaySoundCommand("/audio/button_click.wav").Execute();
          }
        });

        // add private 2D array variable
        this.dungeonButtons[i][j] = b;
      }
    }
    // color every valid adjacent dungeon space.
    java.net.URL imageURL = ReedDemo.class.getResource("/arts/primogem.png");
    ImageIcon icon = new ImageIcon(imageURL);
    DungeonSpace current = this.dungeonArray[this.current.getRow()][this.current.getCol()];
    if (current
        .getPathDirection()
        .contains(Direction.NORTH)) {
      int newRow = this.current.getRow() - 1;
      if (newRow == -1) {
        newRow = this.ROW - 1;
      }
      this.dungeonButtons[newRow][this.current.getCol()].setIcon(icon);
      this.dungeonButtons[newRow][this.current.getCol()].setBackground(Color.pink);
    }
    if (current
        .getPathDirection()
        .contains(Direction.EAST)) {
      int newCol = this.current.getCol() + 1;
      if (newCol == this.COL) {
        newCol = 0;
      }
      this.dungeonButtons[this.current.getRow()][newCol].setIcon(icon);
      this.dungeonButtons[this.current.getRow()][newCol].setBackground(Color.pink);
    }
    if (current
        .getPathDirection()
        .contains(Direction.SOUTH)) {
      int newRow = this.current.getRow() + 1;
      if (newRow == this.ROW) {
        newRow = 0;
      }
      this.dungeonButtons[newRow][this.current.getCol()].setIcon(icon);
      this.dungeonButtons[newRow][this.current.getCol()].setBackground(Color.pink);
    }
    if (current
        .getPathDirection()
        .contains(Direction.WEST)) {
      int newCol = this.current.getCol() - 1;
      if (newCol == -1) {
        newCol = this.COL - 1;
      }
      this.dungeonButtons[this.current.getRow()][newCol].setIcon(icon);
      this.dungeonButtons[this.current.getRow()][newCol].setBackground(Color.pink);
    }
    // add buttons to dungeon panel.
    for (int i = 0; i < this.ROW; i++) {
      for (int j = 0; j < this.COL; j++) {
        dungeon.add(dungeonButtons[i][j]);
      }
    }

    // add treasure at current location to player.
    DungeonSpace currentSpace = this.dungeonArray[this.current.getRow()][this.current.getCol()];
    if (currentSpace.hasTreasure()) {
      for (Treasure t : currentSpace.getTreasure()) {
        this.player.pickUpTreasure(t);
        new PlaySoundCommand("/audio/gold.wav").Execute();
      }
    }

    // adding other components to the gui
    // intialize boxlayout for infoDisplay panel.
    JPanel playerInfoPane = new JPanel();
    BoxLayout box = new BoxLayout(playerInfoPane, BoxLayout.Y_AXIS);
    playerInfoPane.setLayout(box);
    playerInfoPane.setSize(new Dimension(300, 600));
    this.infoDisplay.setLayout(new BorderLayout());

    // add basic player information
    playerInfoPane.add(new JLabel(String.format("Player: %s\n", this.playerName)),
        BorderLayout.CENTER);
    playerInfoPane.add(new JLabel("\n"), BorderLayout.NORTH);
    playerInfoPane.add(new JLabel(
        String.format("Position: %s\n", this.current.toString())),
        BorderLayout.CENTER);
    playerInfoPane.add(new JLabel("\n"), BorderLayout.NORTH);
    playerInfoPane.add(new JLabel("Treasures: \n"), BorderLayout.NORTH);
    // Diamond count
    int diamondCount = 0;
    if (this.player.getTreasure().get(Treasure.DIAMOND) != null) {
      diamondCount = this.player.getTreasure().get(Treasure.DIAMOND);
    }
    playerInfoPane.add(new JLabel(
        String.format("Diamond --- %d", diamondCount)), BorderLayout.NORTH);
    // Sapphire count
    int sapphireCount = 0;
    if (this.player.getTreasure().get(Treasure.SAPPHIRE) != null) {
      sapphireCount = this.player.getTreasure().get(Treasure.SAPPHIRE);
    }
    playerInfoPane.add(new JLabel(
        String.format("Sapphire --- %d", sapphireCount)), BorderLayout.NORTH);
    // Ruby count
    int rubyCount = 0;
    if (this.player.getTreasure().get(Treasure.RUBY) != null) {
      rubyCount = this.player.getTreasure().get(Treasure.RUBY);
    }
    playerInfoPane.add(new JLabel(
        String.format("Ruby    ---    %d", rubyCount)), BorderLayout.NORTH);
    JTextPane message = new JTextPane();
    if (currentSpace.hasTreasure()) {
      String treasureInfo = "Collected";
      for (Treasure t : currentSpace.getTreasure()) {
        treasureInfo = String.format("%s %s", treasureInfo, t.toString());
      }
      this.dungeonArray[this.current.getRow()][this.current.getCol()].removeTreasures();
      message.setText(treasureInfo);
    }
    this.infoDisplay.add(message, BorderLayout.PAGE_END);
    this.infoDisplay.add(playerInfoPane, BorderLayout.PAGE_START);
    this.gui.add(infoDisplay, BorderLayout.LINE_START);
  }

  public final JComponent getGui() {
    return this.gui;
  }

  public static void main(String[] args) {
  // public static void demo() {
    ReedDemo demo = new ReedDemo();
    JFrame f = new JFrame("Dungeon Impact");
    // set frame icon
    java.net.URL imageURL = ReedDemo.class.getResource("/arts/hoyoverseIcon.jpeg");
    ImageIcon frameIcon = new ImageIcon(imageURL);
    f.setIconImage(frameIcon.getImage());

    f.add(demo.getGui());
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLocationByPlatform(true);
    f.pack();

    f.setVisible(true);
    Random r = new Random();
    PlaySoundCommand bgm = null;
    if (r.nextInt(2) == 0) {
      bgm = new PlaySoundCommand("/audio/liyuebattle1.wav");
    } else {
      bgm = new PlaySoundCommand("/audio/liyuebattle2.wav");
    }
    bgm.loop = true;
    bgm.Execute();

  }

}
