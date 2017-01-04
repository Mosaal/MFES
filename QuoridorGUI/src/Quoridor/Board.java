package Quoridor;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Board {
  private VDMSeq board = SeqUtil.seq();

  public void cg_init_Board_3(final Board b) {

    board = new Board(b.getBoard()).getBoard();
    return;
  }

  public void cg_init_Board_2(final VDMSeq b) {

    for (Iterator iterator_1 = SetUtil.range(1L, 9L).iterator(); iterator_1.hasNext(); ) {
      Number r = (Number) iterator_1.next();
      VDMSeq temp = SeqUtil.seq();
      for (Iterator iterator_2 = SetUtil.range(1L, 9L).iterator(); iterator_2.hasNext(); ) {
        Number c = (Number) iterator_2.next();
        Space s = new Space(0L, r, c);
        s.setValue(((Space) Utils.get(((VDMSeq) Utils.get(b, r)), c)).getValue());
        s.setCorner(((Space) Utils.get(((VDMSeq) Utils.get(b, r)), c)).getCorner());
        s.setPathUp(((Space) Utils.get(((VDMSeq) Utils.get(b, r)), c)).getPathUp());
        s.setPathDown(((Space) Utils.get(((VDMSeq) Utils.get(b, r)), c)).getPathDown());
        s.setPathLeft(((Space) Utils.get(((VDMSeq) Utils.get(b, r)), c)).getPathLeft());
        s.setPathRight(((Space) Utils.get(((VDMSeq) Utils.get(b, r)), c)).getPathRight());
        temp = SeqUtil.conc(Utils.copy(temp), SeqUtil.seq(s));
      }
      board = SeqUtil.conc(Utils.copy(board), SeqUtil.seq(Utils.copy(temp)));
    }
    return;
  }

  public void cg_init_Board_1() {

    for (Iterator iterator_3 = SetUtil.range(1L, 9L).iterator(); iterator_3.hasNext(); ) {
      Number r = (Number) iterator_3.next();
      VDMSeq temp = SeqUtil.seq();
      for (Iterator iterator_4 = SetUtil.range(1L, 9L).iterator(); iterator_4.hasNext(); ) {
        Number c = (Number) iterator_4.next();
        temp = SeqUtil.conc(Utils.copy(temp), SeqUtil.seq(new Space(0L, r, c)));
      }
      board = SeqUtil.conc(Utils.copy(board), SeqUtil.seq(Utils.copy(temp)));
    }
    return;
  }

  public Board() {

    cg_init_Board_1();
  }

  public Board(final VDMSeq b) {

    cg_init_Board_2(Utils.copy(b));
  }

  public Board(final Board b) {

    cg_init_Board_3(b);
  }

  public VDMSeq getBoard() {

    return Utils.copy(board);
  }

  public void setValue(final Number v, final Number r, final Number c) {

    ((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c)).setValue(v);
  }

  public Boolean movePiece(final Number r, final Number c, final Player pl) {

    Boolean ret = false;
    if (Utils.equals(r, pl.getRow())) {
      if (Utils.equals(c, pl.getCol())) {
        return ret;
      }
    }

    Boolean andResult_4 = false;

    if (Utils.equals(pl.getRow(), r)) {
      if (pl.getCol().longValue() - c.longValue() > 1L) {
        andResult_4 = true;
      }
    }

    if (andResult_4) {
      return ret;
    }

    Boolean andResult_5 = false;

    if (Utils.equals(pl.getCol(), c)) {
      if (pl.getRow().longValue() - r.longValue() > 1L) {
        andResult_5 = true;
      }
    }

    if (andResult_5) {
      return ret;
    }

    Boolean andResult_6 = false;

    if (Utils.equals(pl.getRow(), r)) {
      if (c.longValue() - pl.getCol().longValue() > 1L) {
        andResult_6 = true;
      }
    }

    if (andResult_6) {
      return ret;
    }

    Boolean andResult_7 = false;

    if (Utils.equals(pl.getCol(), c)) {
      if (r.longValue() - pl.getRow().longValue() > 1L) {
        andResult_7 = true;
      }
    }

    if (andResult_7) {
      return ret;
    }

    if (Utils.equals(((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c)).getValue(), 0L)) {
      if (Utils.equals(r, pl.getRow())) {
        if (c.longValue() < pl.getCol().longValue()) {
          if (Utils.equals(
              ((Space) Utils.get(((VDMSeq) Utils.get(board, pl.getRow())), pl.getCol()))
                  .getPathLeft(),
              false)) {
            ret = true;
          }

        } else {
          if (Utils.equals(
              ((Space) Utils.get(((VDMSeq) Utils.get(board, pl.getRow())), pl.getCol()))
                  .getPathRight(),
              false)) {
            ret = true;
          }
        }
      }

      if (Utils.equals(c, pl.getCol())) {
        if (r.longValue() < pl.getRow().longValue()) {
          if (Utils.equals(
              ((Space) Utils.get(((VDMSeq) Utils.get(board, pl.getRow())), pl.getCol()))
                  .getPathUp(),
              false)) {
            ret = true;
          }

        } else {
          if (Utils.equals(
              ((Space) Utils.get(((VDMSeq) Utils.get(board, pl.getRow())), pl.getCol()))
                  .getPathDown(),
              false)) {
            ret = true;
          }
        }
      }
    }

    if (Utils.equals(ret, true)) {
      ((Space) Utils.get(((VDMSeq) Utils.get(board, pl.getRow())), pl.getCol())).setValue(0L);
    }

    return ret;
  }

  public Boolean placeWall(final Number r, final Number c, final Number dir) {

    Boolean andResult_10 = false;

    if (Utils.equals(r, 1L)) {
      if (Utils.equals(dir, Space.UP)) {
        andResult_10 = true;
      }
    }

    if (andResult_10) {
      return false;
    }

    Boolean andResult_11 = false;

    if (Utils.equals(r, 9L)) {
      if (Utils.equals(dir, Space.DOWN)) {
        andResult_11 = true;
      }
    }

    if (andResult_11) {
      return false;
    }

    Boolean andResult_12 = false;

    if (Utils.equals(c, 1L)) {
      if (Utils.equals(dir, Space.LEFT)) {
        andResult_12 = true;
      }
    }

    if (andResult_12) {
      return false;
    }

    Boolean andResult_13 = false;

    if (Utils.equals(c, 9L)) {
      if (Utils.equals(dir, Space.RIGHT)) {
        andResult_13 = true;
      }
    }

    if (andResult_13) {
      return false;
    }

    Boolean orResult_1 = false;

    if (Utils.equals(dir, Space.UP)) {
      orResult_1 = true;
    } else {
      orResult_1 = Utils.equals(dir, Space.DOWN);
    }

    if (orResult_1) {
      if (Utils.equals(
          ((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c)).getPathRight(), true)) {
        return false;
      }

    } else {
      if (Utils.equals(
          ((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c)).getPathDown(), true)) {
        return false;
      }
    }

    if (Utils.equals(dir, Space.UP)) {
      if (Utils.equals(
          ((Space) Utils.get(((VDMSeq) Utils.get(board, r.longValue() - 1L)), c)).getPathRight(),
          true)) {
        return false;
      }
    }

    if (Utils.equals(dir, Space.DOWN)) {
      if (Utils.equals(
          ((Space) Utils.get(((VDMSeq) Utils.get(board, r.longValue() + 1L)), c)).getPathRight(),
          true)) {
        return false;
      }
    }

    if (Utils.equals(dir, Space.LEFT)) {
      if (Utils.equals(
          ((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c.longValue() - 1L)).getPathDown(),
          true)) {
        return false;
      }
    }

    if (Utils.equals(dir, Space.RIGHT)) {
      if (Utils.equals(
          ((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c.longValue() + 1L)).getPathDown(),
          true)) {
        return false;
      }
    }

    if (Utils.equals(dir, Space.UP)) {
      if (Utils.equals(
          ((Space) Utils.get(((VDMSeq) Utils.get(board, r.longValue() - 1L)), c)).getCorner(),
          true)) {
        return false;
      }
    }

    Boolean orResult_2 = false;

    if (Utils.equals(dir, Space.DOWN)) {
      orResult_2 = true;
    } else {
      orResult_2 = Utils.equals(dir, Space.RIGHT);
    }

    if (orResult_2) {
      if (Utils.equals(((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c)).getCorner(), true)) {
        return false;
      }
    }

    if (Utils.equals(dir, Space.LEFT)) {
      if (Utils.equals(
          ((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c.longValue() - 1L)).getCorner(),
          true)) {
        return false;
      }
    }

    if (Utils.equals(dir, Space.UP)) {
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c)).setPathRight(true);
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c.longValue() + 1L)).setPathLeft(true);
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r.longValue() - 1L)), c)).setPathRight(true);
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r.longValue() - 1L)), c.longValue() + 1L))
          .setPathLeft(true);
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r.longValue() - 1L)), c)).setCorner(true);
      return true;
    }

    if (Utils.equals(dir, Space.DOWN)) {
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c)).setPathRight(true);
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c.longValue() + 1L)).setPathLeft(true);
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r.longValue() + 1L)), c)).setPathRight(true);
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r.longValue() + 1L)), c.longValue() + 1L))
          .setPathLeft(true);
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c)).setCorner(true);
      return true;
    }

    if (Utils.equals(dir, Space.LEFT)) {
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c)).setPathDown(true);
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r.longValue() + 1L)), c)).setPathUp(true);
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c.longValue() - 1L)).setPathDown(true);
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r.longValue() + 1L)), c.longValue() - 1L))
          .setPathUp(true);
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c.longValue() - 1L)).setCorner(true);
      return true;
    }

    if (Utils.equals(dir, Space.RIGHT)) {
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c)).setPathDown(true);
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r.longValue() + 1L)), c)).setPathUp(true);
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c.longValue() + 1L)).setPathDown(true);
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r.longValue() + 1L)), c.longValue() + 1L))
          .setPathUp(true);
      ((Space) Utils.get(((VDMSeq) Utils.get(board, r)), c)).setCorner(true);
      return true;
    }

    return false;
  }

  public String toString() {

    return "Board{" + "board := " + Utils.toString(board) + "}";
  }
}
