package demo;

import demo.Direction;
import demo.Position;
import java.util.HashMap;
import java.util.Map;
import demo.Treasure;

/**
 * DungeonPlayer class defining player in the dungeon.
 *
 */

public class DungeonPlayer implements Player {
  
  private String name;
  private Position position;
  private Map<Treasure, Integer> treasures;
  
  /**
   * DungeonPlayer constructor.
   * @param name name of player
   * @param startLoc start location of player
   */
  
  public DungeonPlayer(String name, Position startLoc) {
    this.name = name;
    this.position = startLoc;
    this.treasures = new HashMap<Treasure, Integer>();
  }
  
  @Override
  public String getName() {
    return new String(this.name);
  }

  @Override
  public Position getLoc() {
    return new Position(this.position.getRow(), this.position.getCol());
  }

  @Override
  public void moveTo(Position p) {
    this.position = p;
  }
  
  @Override
  public void pickUpTreasure(Treasure t) {
    if (this.treasures.containsKey(t)) {
      int count = this.treasures.get(t);
      this.treasures.put(t, count + 1);
    } else {
      this.treasures.put(t, 1);
    }
  }
  
  @Override
  public String toString() {
    String res = String.format("Player: %s\n", this.name);
    res = String.format("%sPosition: %s\n", res, this.position.toString());
    res = String.format("%sTreasure:\n", res);
    
    if (this.treasures.size() == 0) {
      res = String.format("%sNone\n", res);
    } else {
      for (Treasure t : this.treasures.keySet()) {
        res = String.format("%s%s: %d\n", res, t.toString(), this.treasures.get(t));
      }
    }
    return res;
  }

  @Override
  public Map<Treasure, Integer> getTreasure() {
    Map<Treasure, Integer> temp = new HashMap<Treasure, Integer>();
    for (Treasure t : this.treasures.keySet()) {
      temp.put(t, this.treasures.get(t));
    }
    return temp;
  }
}
