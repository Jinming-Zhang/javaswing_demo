package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import demo.Treasure;

/**
 * Cava class representing a cave in the dungeon.
 *
 */

public class Cave implements DungeonSpace {
  
  Position position;
  List<Direction> directions;
  List<Treasure> treasures;
  
  /**
   * Cave constructor.
   * @param p position of the cave
   * @param dir possible directions of movement
   */
  public Cave(Position p, int[] dir) {
    int counter = 0;
    this.directions = new ArrayList<Direction>();
    if (dir[0] == 1) {
      counter += 1;
      this.directions.add(Direction.NORTH);
    }
    if (dir[1] == 1) {
      counter += 1;
      this.directions.add(Direction.EAST);
    }
    if (dir[2] == 1) {
      counter += 1;
      this.directions.add(Direction.SOUTH);
    }
    if (dir[3] == 1) {
      counter += 1;
      this.directions.add(Direction.WEST);
    }
    
    if (counter == 2) {
      throw new IllegalArgumentException("Directions cannot be 2.");
    }
    
    this.position = p;
    this.treasures = new ArrayList<Treasure>();
  }
  
  @Override
  public Position getLoc() {
    return new Position(this.position.getRow(), this.position.getCol());
  }

  @Override
  public List<Direction> getPathDirection() {
    List<Direction> directionCopy = new ArrayList<Direction>();
    directionCopy.addAll(this.directions);
    return directionCopy;
  }

  @Override
  public boolean hasTreasure() {
    if (this.treasures == null || this.treasures.size() == 0) {
      return false;
    } else if (this.treasures.size() > 0) {
      return true;
    }
    return false;
  }

  @Override
  public List<Treasure> getTreasure() {
    List<Treasure> treasureCopy = new ArrayList<Treasure>();
    treasureCopy.addAll(this.treasures);
    return treasureCopy;
  }

  @Override
  public void removeTreasures() {
    this.treasures.clear();
  }

  @Override
  public void addTreasure(Treasure t) {
    this.treasures.add(t);
  }
  
  /**
   * Add treasure to the cave.
   */
  @Override
  public void addTreasure() {
    Random random = new Random();
    int hasDiamond = random.nextInt(2);
    int hasSapphire = random.nextInt(2);
    int hasRuby = random.nextInt(2);
    this.treasures = new ArrayList<Treasure>();
    if (hasDiamond == 1) {
      this.treasures.add(Treasure.DIAMOND);
    } else if (hasSapphire == 1) {
      this.treasures.add(Treasure.SAPPHIRE);
    } else if (hasRuby == 1) {
      this.treasures.add(Treasure.RUBY);
    }
    
    if (this.treasures.size() == 0) {
      this.treasures.add(Treasure.DIAMOND);
    }
  }
  
  @Override
  public String toString() {
    String res = String.format("Cave: %s\nPath:", this.position.toString());
    for (Direction d : this.directions) {
      res = String.format("%s %s,", res, d.toString());
    }
    if (",".equals(res.substring(res.length() - 1))) {
      res = new String(res.substring(0, res.length() - 1));
    }
    res = String.format("%s\nTreasure:", res);
    if (this.treasures.isEmpty()) {
      res = String.format("%s None", res);
    } else {
      for (Treasure t : this.treasures) {
        res = String.format("%s %s,", res, t.toString());
      }
      if (",".equals(res.substring(res.length() - 1))) {
        res = new String(res.substring(0, res.length() - 1));
      }   
    }
 
    return String.format("%s\n", res);
  }

}
