package Quoridor;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Player {
  private Number row;
  private Number col;
  private Number value;
  private Number numWalls = 10L;

  public void cg_init_Player_1(final Number v, final Number r, final Number c) {

    row = r;
    col = c;
    value = v;
    return;
  }

  public Player(final Number v, final Number r, final Number c) {

    cg_init_Player_1(v, r, c);
  }

  public Number getRow() {

    return row;
  }

  public Number getCol() {

    return col;
  }

  public Number getValue() {

    return value;
  }

  public Number getNumWalls() {

    return numWalls;
  }

  public void setRow(final Number r) {

    row = r;
  }

  public void setCol(final Number c) {

    col = c;
  }

  public void decNumWalls() {

    numWalls = numWalls.longValue() - 1L;
  }

  public Player() {}

  public String toString() {

    return "Player{"
        + "row := "
        + Utils.toString(row)
        + ", col := "
        + Utils.toString(col)
        + ", value := "
        + Utils.toString(value)
        + ", numWalls := "
        + Utils.toString(numWalls)
        + "}";
  }
}
