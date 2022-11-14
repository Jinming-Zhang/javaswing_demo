package demo;

import demo.Direction;
import demo.Position;
import java.util.Map;
import demo.Treasure;

/**
 * Player interface.
 *
 */

public interface Player {
  
  /**
   * Getter for player name.
   * @return player name
   */
  String getName();
  
  /**
   * Getter for player location.
   * @return player name
   */
  Position getLoc();
  
  /**
   * Move player to a new postion.
   * @param p next position
   */
  void moveTo(Position p);
  
  /**
   * Have player pick up treasure(s).
   * @param t treasures
   */
  void pickUpTreasure(Treasure t);
  
  /**
   * Getter for treasure.
   * @return Map containing treasures.
   */
  Map<Treasure, Integer> getTreasure();
}
