package demo;

/**
 * Inner class for storing positions of maze.
 * Has a row and a column value.
 *
 */
public class Position {
  private final int row;
  private final int col;
  
  /**
   * constructor.
   * @param x row value
   * @param y col value
   */
  public Position(int x, int y) {
    this.row = x;
    this.col = y;
  }
  
  /**
   * getter for row.
   * @return row value
   */
  public int getRow() {
    return this.row;
  }
  
  /**
   * getter for col.
   * @return col value
   */
  public int getCol() {
    return this.col;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Position)) {
      return false;
    }
    Position that = (Position) o;
    if (this.row == that.row && this.col == that.col) {
      return true;
    }
    return false;
  }
  
  @Override
  public int hashCode() {
    int res = 17;
    res = res + 31 * Integer.hashCode(this.row);
    res = res + 31 * Integer.hashCode(this.col);
    return res;
  }
  
  @Override
  public String toString() {
    return String.format("(%d, %d)", this.row, this.col);
  }
  
}