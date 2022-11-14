package demo;

import java.util.ArrayList;
import java.util.List;
import demo.Treasure;

/**
 * Tunnel class representing a tunnel in the dungeon.
 *
 */

public class Tunnel implements DungeonSpace {
  
  private Position position;
  private List<Direction> directions;
  
  /**
   * Tunnel constructor.
   * @param p position of the tunnel
   * @param direction directions it can go to
   */
  
  public Tunnel(Position p, int[] direction) {
    this.position = p;
    
    // check directions:
    int counter = 0;
    for (int i : direction) {
      if (i == 1) {
        counter += 1;
      }
    }
    
    // throw exception if numbers of directions are incorrect.
    if (counter != 2) {
      throw new IllegalArgumentException("Invalid number of directions.");
    }
    
    // add directions.
    this.directions = new ArrayList<Direction>();
    if (direction[0] == 1) {
      this.directions.add(Direction.NORTH);
    }
    if (direction[1] == 1) {
      this.directions.add(Direction.EAST);
    }
    if (direction[2] == 1) {
      this.directions.add(Direction.SOUTH);
    }
    if (direction[3] == 1) {
      this.directions.add(Direction.WEST);
    }
  }
  
  @Override
  public Position getLoc() {
    return new Position(this.position.getRow(), 
        this.position.getCol());
  }

  @Override
  public List<Direction> getPathDirection() {
    List<Direction> temp = new ArrayList<Direction>();
    temp.addAll(this.directions);
    return temp;
  }

  @Override
  public boolean hasTreasure() {
    return false;
  }

  @Override
  public List<Treasure> getTreasure() {
    return null;
  }
  
  @Override
  public String toString() {
    String res = String.format("Tunnel: %s\n", this.position.toString());
    res = String.format("%sPath:", res);
    for (Direction d : this.directions) {
      res = String.format("%s %s,", res, d.toString());
    }
    if (",".equals(res.substring(res.length() - 1))) {
      res = new String(res.substring(0, res.length() - 1));
    }
    return String.format("%s\n", res);
  }

  @Override
  public void removeTreasures() {
    // a tunnel has no treasure, therefore, it cannot remove any treasures.
    
  }

  @Override
  public void addTreasure() {
    // a tunnel has no treasure.
    return;
  }

  @Override
  public void addTreasure(Treasure t) {
    // a tunnel has no treasure.
    return;
  }
}
