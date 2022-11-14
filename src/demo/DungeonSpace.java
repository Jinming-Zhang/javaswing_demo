package demo;

import java.util.List;
import demo.Treasure;

/**
 * Interface for caves and tunnels.
 *
 */

public interface DungeonSpace {
  
  /**
   * Getter for current location.
   * @return Position
   */
  Position getLoc();
  
  /**
   * Getter for available path directions.
   * @return a list of path directions.
   */
  List<Direction> getPathDirection();
  
  /**
   * Shows whether there is treasure at this space. 
   * @return return true if current space contains treasure(s)
   */
  boolean hasTreasure();
  
  /**
   * Add a random treasure.
   */
  void addTreasure();
  
  /**
   * Add an indicated treasure.
   * @param t treasure to add
   */
  void addTreasure(Treasure t);
  
  /**
   * Getter for current treasures.
   * @return a list of treasures.
   */
  List<Treasure> getTreasure();
  
  /**
   * Remove treasures from current space as player picks it up.
   */
  void removeTreasures();
}
