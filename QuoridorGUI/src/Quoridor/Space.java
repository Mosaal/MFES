package Quoridor;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Space {
  public static Number UP = 1L;
  public static Number DOWN = 2L;
  public static Number LEFT = 3L;
  public static Number RIGHT = 4L;
  private Number row;
  private Number col;
  private Number value;
  private Boolean corner = false;
  private VDMSeq paths = SeqUtil.seq(false, false, false, false);

  public void cg_init_Space_1(final Number v, final Number r, final Number c) {

    row = r;
    col = c;
    value = v;
    if (Utils.equals(r, 1L)) {
      Utils.mapSeqUpdate(paths, Space.UP, true);
    }

    if (Utils.equals(r, 9L)) {
      Utils.mapSeqUpdate(paths, Space.DOWN, true);
    }

    if (Utils.equals(c, 1L)) {
      Utils.mapSeqUpdate(paths, Space.LEFT, true);
    }

    if (Utils.equals(c, 9L)) {
      Utils.mapSeqUpdate(paths, Space.RIGHT, true);
    }

    Boolean orResult_3 = false;

    if (Utils.equals(r, 9L)) {
      orResult_3 = true;
    } else {
      orResult_3 = Utils.equals(c, 9L);
    }

    if (orResult_3) {
      corner = true;
    }

    return;
  }

  public Space(final Number v, final Number r, final Number c) {

    cg_init_Space_1(v, r, c);
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

  public Boolean getCorner() {

    return corner;
  }

  public Boolean getPathUp() {

    return ((Boolean) Utils.get(paths, Space.UP));
  }

  public Boolean getPathDown() {

    return ((Boolean) Utils.get(paths, Space.DOWN));
  }

  public Boolean getPathLeft() {

    return ((Boolean) Utils.get(paths, Space.LEFT));
  }

  public Boolean getPathRight() {

    return ((Boolean) Utils.get(paths, Space.RIGHT));
  }

  public void setValue(final Number v) {

    value = v;
  }

  public void setCorner(final Boolean b) {

    corner = b;
  }

  public void setPathUp(final Boolean p) {

    Utils.mapSeqUpdate(paths, Space.UP, p);
  }

  public void setPathDown(final Boolean p) {

    Utils.mapSeqUpdate(paths, Space.DOWN, p);
  }

  public void setPathLeft(final Boolean p) {

    Utils.mapSeqUpdate(paths, Space.LEFT, p);
  }

  public void setPathRight(final Boolean p) {

    Utils.mapSeqUpdate(paths, Space.RIGHT, p);
  }

  public Space() {}

  public String toString() {

    return "Space{"
        + "UP := "
        + Utils.toString(UP)
        + ", DOWN := "
        + Utils.toString(DOWN)
        + ", LEFT := "
        + Utils.toString(LEFT)
        + ", RIGHT := "
        + Utils.toString(RIGHT)
        + ", row := "
        + Utils.toString(row)
        + ", col := "
        + Utils.toString(col)
        + ", value := "
        + Utils.toString(value)
        + ", corner := "
        + Utils.toString(corner)
        + ", paths := "
        + Utils.toString(paths)
        + "}";
  }
}
