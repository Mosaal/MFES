package Quoridor;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Game {
  private Number turn;
  private Board board;
  private Player player1;
  private Player player2;

  public void cg_init_Game_1() {

    turn = 1L;
    board = new Board();
    player2 = new Player(2L, 1L, 5L);
    player1 = new Player(1L, 9L, 5L);
    return;
  }

  public Game() {

    cg_init_Game_1();
  }

  public Board getBoard() {

    return board;
  }

  public Player getPlayer1() {

    return player1;
  }

  public Player getPlayer2() {

    return player2;
  }

  public Number getTurn() {

    return turn;
  }

  public Boolean movePiece(final Number r, final Number c) {

    Boolean ret = false;
    if (Utils.equals(turn, 1L)) {
      if (Utils.equals(board.movePiece(r, c, player1), true)) {
        ret = true;
        player1.setRow(r);
        player1.setCol(c);
        board.setValue(player1.getValue(), r, c);
      }
    }

    if (Utils.equals(turn, 2L)) {
      if (Utils.equals(board.movePiece(r, c, player2), true)) {
        ret = true;
        player2.setRow(r);
        player2.setCol(c);
        board.setValue(player2.getValue(), r, c);
      }
    }

    if (Utils.equals(ret, true)) {
      switchTurn();
    }

    return ret;
  }

  public Boolean placeWall(final Number r, final Number c, final Number dir) {

    Boolean ret = false;
    Board b_temp = new Board(board);
    if (Utils.equals(turn, 1L)) {
      if (player1.getNumWalls().longValue() > 0L) {
        if (Utils.equals(b_temp.placeWall(r, c, dir), true)) {
          Boolean andResult_13 = false;

          if (Utils.equals(
              checkPath(
                  b_temp,
                  1L,
                  ((Space)
                      Utils.get(
                          ((VDMSeq) Utils.get(b_temp.getBoard(), player1.getRow())),
                          player1.getCol()))),
              true)) {
            if (Utils.equals(
                checkPath(
                    b_temp,
                    9L,
                    ((Space)
                        Utils.get(
                            ((VDMSeq) Utils.get(b_temp.getBoard(), player2.getRow())),
                            player2.getCol()))),
                true)) {
              andResult_13 = true;
            }
          }

          if (andResult_13) {
            if (Utils.equals(board.placeWall(r, c, dir), true)) {
              ret = true;
              player1.decNumWalls();
            }
          }
        }
      }
    }

    if (Utils.equals(turn, 2L)) {
      if (player2.getNumWalls().longValue() > 0L) {
        if (Utils.equals(b_temp.placeWall(r, c, dir), true)) {
          Boolean andResult_14 = false;

          if (Utils.equals(
              checkPath(
                  b_temp,
                  1L,
                  ((Space)
                      Utils.get(
                          ((VDMSeq) Utils.get(b_temp.getBoard(), player1.getRow())),
                          player1.getCol()))),
              true)) {
            if (Utils.equals(
                checkPath(
                    b_temp,
                    9L,
                    ((Space)
                        Utils.get(
                            ((VDMSeq) Utils.get(b_temp.getBoard(), player2.getRow())),
                            player2.getCol()))),
                true)) {
              andResult_14 = true;
            }
          }

          if (andResult_14) {
            if (Utils.equals(board.placeWall(r, c, dir), true)) {
              ret = true;
              player2.decNumWalls();
            }
          }
        }
      }
    }

    if (Utils.equals(ret, true)) {
      switchTurn();
    }

    return ret;
  }

  public Number checkWinner() {

    Number ret = 0L;
    if (Utils.equals(player1.getRow(), 1L)) {
      ret = player1.getValue();
    }

    if (Utils.equals(player2.getRow(), 9L)) {
      ret = player2.getValue();
    }

    return ret;
  }

  private void switchTurn() {

    if (Utils.equals(turn, player1.getValue())) {
      turn = player2.getValue();
    } else {
      turn = player1.getValue();
    }
  }

  public VDMSeq getNewPossibleSpaces(final Board b, final Space s) {

    VDMSeq newpos = SeqUtil.seq();
    Number currentrow = s.getRow();
    Number currentcol = s.getCol();
    if (Utils.equals(
        ((Space) Utils.get(((VDMSeq) Utils.get(b.getBoard(), currentrow)), currentcol)).getPathUp(),
        false)) {
      newpos =
          SeqUtil.conc(
              Utils.copy(newpos),
              SeqUtil.seq(
                  ((Space)
                      Utils.get(
                          ((VDMSeq) Utils.get(board.getBoard(), currentrow.longValue() - 1L)),
                          currentcol))));
    }

    if (Utils.equals(
        ((Space) Utils.get(((VDMSeq) Utils.get(b.getBoard(), currentrow)), currentcol))
            .getPathDown(),
        false)) {
      newpos =
          SeqUtil.conc(
              Utils.copy(newpos),
              SeqUtil.seq(
                  ((Space)
                      Utils.get(
                          ((VDMSeq) Utils.get(board.getBoard(), currentrow.longValue() + 1L)),
                          currentcol))));
    }

    if (Utils.equals(
        ((Space) Utils.get(((VDMSeq) Utils.get(b.getBoard(), currentrow)), currentcol))
            .getPathLeft(),
        false)) {
      newpos =
          SeqUtil.conc(
              Utils.copy(newpos),
              SeqUtil.seq(
                  ((Space)
                      Utils.get(
                          ((VDMSeq) Utils.get(board.getBoard(), currentrow)),
                          currentcol.longValue() - 1L))));
    }

    if (Utils.equals(
        ((Space) Utils.get(((VDMSeq) Utils.get(b.getBoard(), currentrow)), currentcol))
            .getPathRight(),
        false)) {
      newpos =
          SeqUtil.conc(
              Utils.copy(newpos),
              SeqUtil.seq(
                  ((Space)
                      Utils.get(
                          ((VDMSeq) Utils.get(board.getBoard(), currentrow)),
                          currentcol.longValue() + 1L))));
    }

    return Utils.copy(newpos);
  }

  public Boolean checkPath(final Board b, final Number er, final Space s) {

    Number currentrow = 0L;
    VDMSet visited = SetUtil.set();
    VDMSeq pathBoard = SeqUtil.seq();
    VDMSeq possiblePaths = null;
    visited = SetUtil.union(Utils.copy(visited), SetUtil.set(s));
    pathBoard = SeqUtil.conc(Utils.copy(pathBoard), SeqUtil.seq(s));
    Boolean whileCond_1 = true;
    while (whileCond_1) {
      whileCond_1 = pathBoard.size() > 0L;
      if (!(whileCond_1)) {
        break;
      }

      {
        possiblePaths = getNewPossibleSpaces(b, ((Space) Utils.get(pathBoard, 1L)));
        currentrow = ((Space) Utils.get(pathBoard, 1L)).getRow();
        pathBoard = SeqUtil.tail(Utils.copy(pathBoard));
        if (Utils.equals(currentrow, er)) {
          return true;
        }

        for (Iterator iterator_5 = SetUtil.range(1L, possiblePaths.size()).iterator();
            iterator_5.hasNext();
            ) {
          Number i = (Number) iterator_5.next();
          if (!(SetUtil.inSet(((Space) Utils.get(possiblePaths, i)), visited))) {
            visited =
                SetUtil.union(
                    Utils.copy(visited), SetUtil.set(((Space) Utils.get(possiblePaths, i))));
            pathBoard =
                SeqUtil.conc(
                    Utils.copy(pathBoard), SeqUtil.seq(((Space) Utils.get(possiblePaths, i))));
          }
        }
      }
    }

    return false;
  }

  public String toString() {

    return "Game{"
        + "turn := "
        + Utils.toString(turn)
        + ", board := "
        + Utils.toString(board)
        + ", player1 := "
        + Utils.toString(player1)
        + ", player2 := "
        + Utils.toString(player2)
        + "}";
  }
}
