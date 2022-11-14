package demo;

import demo.Cave;
import demo.DungeonSpace;
import demo.Position;
import demo.Tunnel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * generate dungeon map using kruskal's algorithm.
 *
 */

public class MapGenerator {

  private int[][][] maze;
  private final int numRows;
  private final int numCols;
  private final boolean wrap;
  private final int interconnectivity;
  private Random random;

  /**
   * constructor for map generator.
   * @param numRows number of rows
   * @param numCols number of columns.
   * @param wrap whether the dungeon is wrapping or not.
   * @param interconnectivity number of possible path from one position to another
   * @param randomSeed seed for random number generator
   */

  public MapGenerator(int numRows, int numCols, boolean wrap, 
      int interconnectivity, long randomSeed) {
    this.maze = new int[numRows][numCols][4];
    this.numRows = numRows;
    this.numCols = numCols;
    this.wrap = wrap;
    this.interconnectivity = interconnectivity;
    this.random = new Random(randomSeed);
    this.generateDungeon();
  }

  /**
   * Check if given position is valid.
   * 
   * @param row row
   * @param col col
   * @return true if position is valid, false otherwise
   */
  private boolean checkPositionValid(int row, int col) {
    if (this.wrap) {
      if (row >= -1 && row <= this.numRows && col >= -1 && col <= this.numCols) {
        return true;
      }
    } else {
      if (row >= 0 && row < this.numRows && col >= 0 && col < this.numCols) {
        return true;
      }
    }
    return false;
  }

  /**
   * Find valid adjacent positions.
   * 
   * @param p current position
   * @return a list of adjacent positions
   */
  private List<Position> getAdjacentPositions(Position p) {
    List<Position> res = new ArrayList<Position>();

    if (checkPositionValid(p.getRow() - 1, p.getCol())) {
      Position tempP = new Position(p.getRow() - 1, p.getCol());

      if (tempP.getRow() == -1) {
        tempP = new Position(this.numRows - 1, p.getCol());
      }
      if (!res.contains(tempP)) {
        res.add(tempP);
      }
    }
    // south
    if (checkPositionValid(p.getRow() + 1, p.getCol())) {
      Position tempP = new Position(p.getRow() + 1, p.getCol());

      if (tempP.getRow() == this.numRows) {
        tempP = new Position(0, p.getCol());
      }
      if (!res.contains(tempP)) {
        res.add(tempP);
      }
    }
    // east
    if (checkPositionValid(p.getRow(), p.getCol() - 1)) {
      Position tempP = new Position(p.getRow(), p.getCol() - 1);

      if (tempP.getCol() == -1) {
        tempP = new Position(p.getRow(), this.numCols - 1);
      }
      if (!res.contains(tempP)) {
        res.add(tempP);
      }
    }
    // west
    if (checkPositionValid(p.getRow(), p.getCol() + 1)) {
      Position tempP = new Position(p.getRow(), p.getCol() + 1);

      if (tempP.getCol() == this.numCols) {
        tempP = new Position(p.getRow(), 0);
      }
      if (!res.contains(tempP)) {
        res.add(tempP);
      }
    }

    return res;
  }

  /**
   * Generate 3d dungeon.
   */
  private void generateDungeon() {
    // reset maze
    // all edges are deleted.
    for (int i = 0; i < this.numRows; i++) {
      for (int j = 0; j < this.numCols; j++) {
        for (int k = 0; k < 4; k++) {
          this.maze[i][j][k] = 0;
        }
      }
    }

    // implement kruskal's algorithm to make a minimum spamming tree.

    // initialize a set containing position values.
    Set<Position> set = new HashSet<Position>();
    List<Position> adj = new ArrayList<Position>();

    //add an initial value to the set.
    int randomX = this.random.nextInt(this.numRows);
    int randomY = this.random.nextInt(this.numCols);
    Position initial = new Position(randomX, randomY);
    set.add(initial);

    // add surroudning positions

    List<Position> initialAdj = this.getAdjacentPositions(initial);
    for (Position p : initialAdj) {
      adj.add(p);
    }

    while (set.size() < this.numRows * this.numCols) { 
      // we want all 6*8 = 48 vertices to be connected 

      // choose one of the adjacent vertices to connect.
      int randIndex = this.random.nextInt(adj.size());
      Position cur = adj.get(randIndex);

      int randDir;      
      while (true) {
        randDir = this.random.nextInt(4);
        // 0 - North, 1 - East, 2 - South, 3 - West
        int row = 0;
        int col = 0;
        if (randDir == 0) { // north
          row = -1;
        } else if (randDir == 1) {  // east
          col = 1;
        } else if (randDir == 2) {  // south
          row = 1;
        } else if (randDir == 3) {  // west
          col = -1;
        }

        // connect it to an adjacent vertex in set.
        Position nextP = new Position(cur.getRow() + row, cur.getCol() + col);

        if (this.wrap) {
          if (nextP.getRow() == -1) {
            nextP = new Position(this.numRows - 1, nextP.getCol());
          } else if (nextP.getRow() == this.numRows) {
            nextP = new Position(0, nextP.getCol());
          } else if (nextP.getCol() == -1) {
            nextP = new Position(nextP.getRow(), this.numCols - 1);
          } else if (nextP.getCol() == this.numCols) {
            nextP = new Position(nextP.getRow(), 0);
          }
        }

        if (set.contains(nextP)) {
          // add both edges
          this.maze[nextP.getRow()][nextP.getCol()][(randDir + 2) % 4] = 1;
          this.maze[cur.getRow()][cur.getCol()][randDir] = 1;
          break;
        } else {
          continue;
        }
      }
      // add it to set
      set.add(cur);

      // remove current position from adj
      for (int i = 0; i < adj.size(); i++) {
        if (adj.get(i).equals(cur)) {
          adj.remove(i);
          break;
        }
      }

      // add surroudning positions
      List<Position> adjT = this.getAdjacentPositions(cur);
      for (Position p : adjT) {
        if (!adj.contains(p) && !set.contains(p)) {
          adj.add(p);
        }
      }
    }

    this.addConnectivity();
  }

  /**
   * increase edges as requested by input interconnectivity.
   */
  private void addConnectivity() {

    if (this.interconnectivity == 0) {
      return;
    }

    Random rand = new Random();

    Map<Position, ArrayList<Integer>> edgeMap = new HashMap<Position, ArrayList<Integer>>();

    for (int i = 0; i < this.numRows; i++) {
      for (int j = 0; j < this.numCols; j++) {
        ArrayList<Integer> neighbours = new ArrayList<Integer>();
        if (this.wrap) {
          for (int k = 0; k < 4; k++) {
            if (this.maze[i][j][k] == 0) {
              neighbours.add(k); 
            }
          }
        } else {
          // north
          if (this.maze[i][j][0] == 0) {
            if (i - 1 >= 0) {
              neighbours.add(0);
            }
          }
          // east
          if (this.maze[i][j][1] == 0) {
            if (j + 1 < this.numCols) {
              neighbours.add(1);
            }
          }
          // south
          if (this.maze[i][j][2] == 0) {
            if (i + 1 < this.numRows) {
              neighbours.add(2);
            }
          }
          // west
          if (this.maze[i][j][3] == 0) {
            if (j - 1 >= 0) {
              neighbours.add(3);
            }
          }
        }
        edgeMap.put(new Position(i, j), neighbours);
      }
    }

    int counter = 0;

    // randomly connect two edges.
    while (counter < this.interconnectivity && edgeMap.size() > 0) {
      int randIndex = rand.nextInt(edgeMap.size());
      Position cur = (Position) edgeMap.keySet().toArray()[randIndex];
      if (edgeMap.get(cur).isEmpty()) {
        edgeMap.remove(cur);
        continue;
      }
      int randDir = rand.nextInt(edgeMap.get(cur).size());
      Position next = null;
      int dir = edgeMap.get(cur).get(randDir);
      if (dir == 0) {
        if (cur.getRow() - 1 == -1) {
          next = new Position(this.numRows - 1, cur.getCol());
        } else {
          next = new Position(cur.getRow() - 1, cur.getCol());
        }
      } else if (dir == 1) {
        if (cur.getCol() + 1 == this.numCols) {
          next = new Position(cur.getRow(), 0);
        } else {
          next = new Position(cur.getRow(), cur.getCol() + 1);
        }
      } else if (dir == 2) {
        if (cur.getRow() + 1 == this.numRows) {
          next = new Position(0, cur.getCol());
        } else {
          next = new Position(cur.getRow() + 1, cur.getCol());
        }
      } else if (dir == 3) {
        if (cur.getCol() - 1 == -1) {
          next = new Position(cur.getRow(), this.numCols - 1);
        } else {
          next = new Position(cur.getRow(), cur.getCol() - 1);
        }
      }

      // connect two edges
      this.maze[cur.getRow()][cur.getCol()][dir] = 1;
      this.maze[next.getRow()][next.getCol()][(dir + 2) % 4] = 1;
      //      System.out.println(String.format("Connected %s and %s", cur, next));

      // remove the both directions from map.
      for (int k = 0; k < edgeMap.get(cur).size(); k++) {
        if (edgeMap.get(cur).get(k) == dir) {
          edgeMap.get(cur).remove(k); 
        }
      }
      if (edgeMap.get(cur).isEmpty()) {
        edgeMap.remove(cur);
      }
      for (int k = 0; k < edgeMap.get(next).size(); k++) {
        if (edgeMap.get(next).get(k) == (dir + 2) % 4) {
          edgeMap.get(next).remove(k); 
        }
      }
      if (edgeMap.get(next).isEmpty()) {
        edgeMap.remove(next);
      }

      counter += 1;
    }

  }

  /**
   * Convert from 3d maze of int to 2d maze of dungeon space.
   * @return 2d DungeonSpace maze
   */
  public DungeonSpace[][] generateMazeSpace() {
    DungeonSpace[][] mazeSpace = new DungeonSpace[this.numRows][this.numCols];
    for (int i = 0; i < this.numRows; i++) {
      for (int j = 0; j < this.numCols; j++) {
        int counter = 0;
        int[] dir = {0, 0, 0, 0};
        for (int k = 0; k < 4; k++) {
          if (this.maze[i][j][k] == 1) {
            counter += 1;
            dir[k] = 1;
          }
        }
        if (counter == 2) {
          mazeSpace[i][j] = new Tunnel(new Position(i, j), dir);
        } else {
          mazeSpace[i][j] = new Cave(new Position(i, j), dir);
        }
      }
    }
    return mazeSpace;
  }

}
